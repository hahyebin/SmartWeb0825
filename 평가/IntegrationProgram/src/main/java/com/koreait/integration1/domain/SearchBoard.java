package com.koreait.integration1.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchBoard {
	private Long no;
	private String title;
	private String content;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date regDate;
	
	
	public SearchBoard() {
		// TODO Auto-generated constructor stub
	}


	public SearchBoard(Long no, String title, String content, Date regDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}


	public Long getNo() {
		return no;
	}


	public void setNo(Long no) {
		this.no = no;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "SearchBoard [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + "]";
	}
	
	
	
}
