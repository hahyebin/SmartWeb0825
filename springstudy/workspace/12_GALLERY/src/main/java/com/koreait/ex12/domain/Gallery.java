package com.koreait.ex12.domain;

import java.sql.Date;

public class Gallery {
	private Long no;
	private String title, writer, content, ip, path, origin, saved;
	private Date created, lastModified;
	
	public Gallery() { 	}
	
	public Gallery(Long no, String title, String writer, String content, String ip, String path, String origin,
			String saved, Date created, Date lastModified) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.ip = ip;
		this.path = path;
		this.origin = origin;
		this.saved = saved;
		this.created = created;
		this.lastModified = lastModified;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSaved() {
		return saved;
	}

	public void setSaved(String saved) {
		this.saved = saved;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "Gallery [no=" + no + ", title=" + title + ", writer=" + writer + ", content=" + content + ", ip=" + ip
				+ ", path=" + path + ", origin=" + origin + ", saved=" + saved + ", created=" + created
				+ ", lastModified=" + lastModified + "]";
	}

	
	
	
	
	
	
	
}
