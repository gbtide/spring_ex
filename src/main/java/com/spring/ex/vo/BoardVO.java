package com.spring.ex.vo;

import java.util.Date;

import com.spring.ex.common.BaseObject;

public class BoardVO extends BaseObject {
	private static final long serialVersionUID = 2079451288971337718L;

	private Integer bno;
	
	private String title;
	
	private String content;
	
	private String writer;
	
	private Date regdate;
	
	private Integer viewcnt;

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Integer getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}

}
