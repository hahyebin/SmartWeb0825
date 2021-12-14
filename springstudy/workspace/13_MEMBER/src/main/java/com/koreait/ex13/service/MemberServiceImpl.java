package com.koreait.ex13.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.koreait.ex13.controller.MemberController;
import com.koreait.ex13.domain.Member;
import com.koreait.ex13.repository.MemberRepository;
import com.koreait.ex13.util.SecurityUtils;

@Service
public class MemberServiceImpl implements MemberService {
// service는 repository와 연결하기
	
	//로그
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	private SqlSessionTemplate sqlSession;
	private JavaMailSender javaMailSender; 
	
	
	@Autowired
	public void setBean(SqlSessionTemplate sqlSession, JavaMailSender javaMailSender) {
		this.sqlSession = sqlSession;
		this.javaMailSender = javaMailSender;
	}
	

	// 아이디 중복체크 구현하기
	@Override
	public Map<String, Object> idCheck(String id) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", repository.selectMemberById(id));
		return map;
	}


    // 이메일 중복체크 구현하기 + 아이디 확인
	@Override
	public Map<String, Object> findMemberByEmail(String email) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", repository.selectMemberByEmail(email));
		return map;
	}

	

	
   // 이메일 인증코드 보내기
	@Override
	public Map<String, Object> sendAuthCode(String email) {
		
		// 인증코드 발생
		String authCode = SecurityUtils.authCode(6);
		
		// 이메일 전송 
		try {
			
			MimeMessage message = javaMailSender.createMimeMessage();
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");                   // 이메일 내용 일반텍스트
			message.setFrom(new InternetAddress("hahyebin9601@gamil.com","인증코드관리자"));  // 보내는사람 
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));       // 받는사람
			message.setSubject("인증 요청 메일입니다."); 									  // 제목
			message.setText("인증번호는  "+ authCode +" 입니다.");							  // 내용
			javaMailSender.send(message);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// view 에 반환
		Map<String, Object> map = new HashMap<>();
		map.put("authCode", authCode);
		
		return map;
	}

	
	// 회원가입하기
	@Override
	public void join(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		
		// 사용자에게 받은 비밀번호를 암호화 해서 db 로 보낸다. (관리자가 알지못하도록)
		member.setPw( SecurityUtils.sha256(member.getPw()));		
		
		// 사용자 입력시 아이디, 비번, 이메일은 정규식으로 막았지만, 이름은 아무 작업도 하지 않았으므로 이름에 크로스 작업이 필요하다.
		member.setName(SecurityUtils.xxs(member.getName()));
		
	    repository.joinMember(member);
	}
	
	// 로그인하기
	@Override
	public void login(HttpServletRequest request) {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setPw(SecurityUtils.sha256(request.getParameter("pw")));
		
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		Member loginUser = repository.login(member);
		if( loginUser != null ) {
			request.getSession().setAttribute("loginUser", loginUser);  // 세션의 사용위해 request를 매개변수로 사용 
		}
		logger.info(member.toString());
	}
	
	
	
	
	// 내 비밀번호 변경
	@Override
	public void updatePw(Member member) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
		member.setPw(SecurityUtils.sha256(member.getPw()));
		repository.updatePw(member);
	}
	
	
	
	
	// 내 정보 변경
   @Override
	public void updateMember(Member member, HttpSession session) {
	   
	   // 사용자 입력시 아이디, 비번, 이메일은 정규식으로 막았지만, 이름은 아무 작업도 하지 않았으므로 이름에 크로스 작업이 필요하다.
	   member.setName(SecurityUtils.xxs(member.getName()));
	 
	   MemberRepository repository = sqlSession.getMapper(MemberRepository.class);		
	   repository.updateMember(member);
	   
	   // 이름과 이메일만 변경하므로 세션 변경
	   Member loginUser = (Member)session.getAttribute("loginUser");
	   loginUser.setName(member.getName());
	   loginUser.setEmail(member.getEmail());
	  
	}
   
   // 탈퇴하기
   @Override
	public void leave(Long no, HttpSession session) {
		MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
	    int result = repository.leaveMember(no);
	    if( result > 0  ) session.invalidate();
	}
   
   
   // 비밀번호 디코딩
	@Override
	public Map<String, Object> presentPwCheck(HttpServletRequest request) {
        String pw = request.getParameter("pw");
        MemberRepository repository = sqlSession.getMapper(MemberRepository.class);
        Member member = repository.selectMemberById(request.getParameter("id"));
        Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", SecurityUtils.sha256(request.getParameter("pw0")).equals(member.getPw()));
		logger.info(pw);
		logger.info(map.toString());
		return map;

	}

	
	
   
   
   
	
} // end of class
