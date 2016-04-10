package com.spring.ex.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode {
	SUCCESS(0), //
	CONRIFM(100),
	FAIL(500),
	BAD_PARAMETER(501);

	int code;

	private ResponseCode(int code) {
		this.code = code;
	}

	@JsonValue
	public int value() {
		return code;
	}
}
