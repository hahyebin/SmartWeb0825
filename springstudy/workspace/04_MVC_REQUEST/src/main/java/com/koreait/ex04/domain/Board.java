package com.koreait.ex04.domain;

public class Board {
	
	// field
	private Long no;         // 필수 
	private String title;    // 필수
	private String context;  // 필수 
	private Long hit;        // 선택 
	
	
	// getter	
	public Long getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContext() {
		return context;
	}
	public Long getHit() {
		return hit;
	}
	
	// constructor 
	private Board(BoardBuilder builder) {
		this.no = builder.no;
		this.title = builder.title;
		this.context = builder.context;
		this.hit = builder.hit;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	// BoardBuilder 클래스를 내부 클래스로 등록 
	public static class BoardBuilder {
		
		// field
		private Long no;         // 필수 
		private String title;    // 필수
		private String context;  // 필수 
		private Long hit;        // 선택 
		
		// constructor : "필수 field"만 작업 
		public BoardBuilder(Long no, String title, String context) {
			super();
			this.no = no;
			this.title = title;
			this.context = context;
		}
		
		// setter : BoardBuilder를 반환함, 선택 field만 작업 
		public BoardBuilder setHit(Long hit) {
			this.hit = hit;
			return this;
		}

		// build() : Board를 반환함 
		public Board build() {
			return new Board(this);  // this= BoardBuild
		}
	}  // BoardBuilder end
} // Board end             ===> Board의 내부클래스로 BoardBuilder 등록함 
