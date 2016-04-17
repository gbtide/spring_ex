package com.spring.ex.model;

public class SearchCriteria extends Criteria {
	private static final long serialVersionUID = 8472846784414825802L;
	
	private String searchType;
	
	private String keyword;
	
	public String getSearchType() {
		return searchType;
	}
	
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
