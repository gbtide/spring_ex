package com.spring.ex.model;

import com.spring.ex.common.BaseObject;

public class Criteria extends BaseObject {
	private static final long serialVersionUID = -108037662699354982L;

	/**
	 * 현재 페이지
	 */
	private int page;
	
	/**
	 * 페이지 당 몇 개의 아이템을 갖는가
	 */
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

}
