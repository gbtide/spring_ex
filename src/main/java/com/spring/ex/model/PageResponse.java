package com.spring.ex.model;

import com.spring.ex.vo.BoardVO;

public class PageResponse extends ListResponse<BoardVO> {
	private static final long serialVersionUID = -6193713769782308638L;

	private PageMaker pageMaker;

	public PageMaker getPageMaker() {
		return pageMaker;
	}

	public void setPageMaker(PageMaker pageMaker) {
		this.pageMaker = pageMaker;
	}
	
}
