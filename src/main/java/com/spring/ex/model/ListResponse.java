package com.spring.ex.model;

import java.util.List;

public class ListResponse<T> extends Response {

	private static final long serialVersionUID = -6278319548171424287L;

	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public ListResponse<T> setList(List<T> list) {
		this.list = list;
		return this;
	}

	public ListResponse(List<T> list) {
		setList(list);
	}

	public ListResponse() {
	}

}
