package com.koreait.video.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.video.domain.Video;
import com.koreait.video.repository.GalleryRepository;

public class GalleryServiceImpl implements GalleryService {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 목록보기
	@Override
	public List<Video> selectGalleryList() {
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class); // 중복되지만 필드로 빼면 오류
		return repository.selectGalleryList();
	}

	// 상세보기
	@Override
	public Video selectGalleryByNo(Long no) {
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		return repository.selectGalleryByNo(no);
	}

	@Override
	public void insertGallery(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {

		// 첨부파일 처리(만약에 사진을 여러개 올린다면, 배열처리로 ..) : 서버에 파일 저장 + DB에 정보저장

		// DB로 보낼 Gallery gallery
		Video gallery = new Video();
		gallery.setWriter(multipartRequest.getParameter("writer"));
		gallery.setTitle(multipartRequest.getParameter("title"));
		gallery.setContent(multipartRequest.getParameter("content"));
		gallery.setIp(multipartRequest.getRemoteAddr());

		// 서버에 파일 저장
		try {
			MultipartFile file = multipartRequest.getFile("file"); // 반환타입은 MultipartFile

			if (file != null && !file.isEmpty()) { // 첨부가 있으면(둘 다 필요)

				// * 저장할 첨부파일명을 UUID로 변경

				// UUID : Universal Unique IDentifier - 범용 고유 식별자
				// UUID : 45454285-d82d-d5e5-d564-125dges6v54g : 하이픈 제외하면 32자리
				// UUID를 파일명으로 사용하면,
				// 1. 파일명 인코딩 해결
				// 2. 파일명 중복 저장해결

				// 첨부파일의 본래 이름 :
				String origin = file.getOriginalFilename();
				// 첨부파일의 확장자 (.jpg .png .jpeg .gif) lastindexof + 1 인경우엔 jpg png jpeg gif
				String extName = origin.substring(origin.lastIndexOf("."));
				String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // UUID클래스를통해 UUID를 랜덤으로 설정하고, 문자열로 변환
																				// 후에 변환된 문자열중에 -있는 경우 "공"으로 바꾼다.

				// 저장된 파일명(saved) 결정
				String saved = uuid + extName;

				// System.out.println(saved);

				// 저장될 경로
				// resources/upload/2021/12/09
				String sep = Matcher.quoteReplacement(File.separator);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String path = "resources" + sep + "upload" + sep + sdf.format(new Date()).replaceAll("-", sep);
				// 실제 경로
				String realPath = multipartRequest.getServletContext().getRealPath(path);

				System.out.println(path);
				
				// 저장될 경로에 디렉터리 만들기 -> 없으면 새로 만들기
				File dir = new File(realPath);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// * 첨부파일 서버에 업로드(예외처리 필요)
				File uploadFile = new File(dir, saved); // new File(경로, 파일)
				file.transferTo(uploadFile); // 업로드 진행 코드

//				// * 썸네일 이미지 생성(예외처리 필요)
//				if( !(extName.toUpperCase().equals("MP4"))) {
//					Thumbnails.of(uploadFile)
//					.size(150, 150)
//					.toFile(new File(realPath, "s_" + saved));
//				} else {
//					
//				}
				
				// 첨부가 있으면 DB에 path, origin, saved저장
				gallery.setPath(path);
				gallery.setOrigin(origin);
				gallery.setSaved(saved);

			} // 첨부된 파일이 있는 경우
			else {

				// 첨부가 없으면 path, origin, saved 빈 문자열처리
				gallery.setPath("");
				gallery.setOrigin("");
				gallery.setSaved("");

			} // 첨부된 파일이 없는 경우

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 마지막으로 설정한 갤러리 객체 DB에 전달
		GalleryRepository repository = sqlSession.getMapper(GalleryRepository.class);
		int result = repository.insertGallery(gallery);
		message(result, response, "새 갤러리가 등록되었습니다", "등록 실패", "/video/gallery/selectGalleryList");

	}

	@Override
	public int updateGallery(Video gallery) {
		return 0;
	}

	@Override
	public int deleteGallery(Long no) {
		return 0;
	}

}
