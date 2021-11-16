package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.MemberDAO;
import dto.MemberDTO;

public class TopJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	
		
		List<MemberDTO> list = MemberDAO.getInstance().selectTopList();
		
		// list를 파일로 만들기
		File file = new File("top.txt");
		try (BufferedWriter bw = new BufferedWriter( new FileWriter(file))) {    // try-catch resource => close() 생략 가능
			for(MemberDTO member : list) {
				bw.write("회원번호 : " + member.getNo()+" \n");
				bw.write("회원아이디 : " +member.getId()+" \n");
				bw.write("회원명 : " +member.getName()+" \n");
				bw.write("회원등급 : " +member.getGrade()+" \n");
				bw.write("회원포인트 : " +member.getPoint()+"");
			}
			System.out.println("top.txt 파일생성완료");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
