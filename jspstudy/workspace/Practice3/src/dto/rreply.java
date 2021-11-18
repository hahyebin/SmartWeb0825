package dto;

import java.sql.Date;

public class Rreply {
	private Long ridx;
	private String writer;
	private String content;
	private Long idx;
	private Date register;
	
	public Rreply() {
		// TODO Auto-generated constructor stub
	}

	public Long getRidx() {
		return ridx;
	}

	public void setRidx(Long ridx) {
		this.ridx = ridx;
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

	public Long getIdx() {
		return idx;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}
	
	
	
	
	
}
