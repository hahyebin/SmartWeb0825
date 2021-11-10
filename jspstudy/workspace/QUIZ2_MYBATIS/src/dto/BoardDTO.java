package dto;

import java.sql.Date;

public class BoardDTO {
	private Long idx;
	private String title;
	private String writer;
	private String content;
	private Date register;
	
	
	 public BoardDTO() {
		// TODO Auto-generated constructor stub
	}

	 // idx 와 register는 DB에서 
	public BoardDTO( String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}
	 
	 
	
	
	
	
	
	
	
}
