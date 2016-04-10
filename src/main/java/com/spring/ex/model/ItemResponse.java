package com.spring.ex.model;

public class ItemResponse<T> extends Response {
	private static final long serialVersionUID = -6824902868860383656L;
	private T item;

	public T getItem() {
		return item;
	}

	public ItemResponse<T> setItem(T item) {
		this.item = item;
		return this;
	}

}
