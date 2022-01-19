package com.koreait.final1.domain;

import java.sql.Date;

public class Board {

	private Long bIdx;
	private String bWriter, bTitle, bContent;
	private Date bDate;
	public Long getbIdx() {
		return bIdx;
	}
	public void setbIdx(Long bIdx) {
		this.bIdx = bIdx;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	@Override
	public String toString() {
		return "Board [bIdx=" + bIdx + ", bWriter=" + bWriter + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bDate=" + bDate + "]";
	}
	
	
}
