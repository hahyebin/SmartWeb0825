package com.koreait.ex12.repository;

import java.util.List;

import com.koreait.ex12.domain.Gallery;

// 인터페이스 경우 GalleryMapper 로도 많이 사용된다.
public interface GalleryRepository {
/**
    GalleryRepository는 gallery.xml 과 직결됨 
    method명 = 태그 id
    반환타입 = resultType
    매개변수 = parameterType
 **/
	
	 // gallery.xml의 id와 메서드명 같게하기
	
	public List<Gallery> selectGalleryList();		// 목록보기 쿼리
	public Gallery selectGalleryByNo(Long no);      // 상세보기 쿼리
	public int insertGallery(Gallery gallery);      // 등록하기 쿼리
	public int updateGallery(Gallery gallery);      // 수정하기 쿼리
	public int deleteGallery(Long no);			    // 삭제하기 쿼리
}


// DB와 연결하는 레파지토리가 인터페이스인 경우.
// mapper의 id와 이름이 같은 repository인터페이스의 추상메서드명을 만든다.

// repository 와 연결하는 service에선 이 repository인터페이스를 통해 mapper에 접근해야하고,
// getMapper() 메서드를 통해 접근한다. (인터페이스는 객체를 만들지 못하기 때문에 이러한 방식을 이용)