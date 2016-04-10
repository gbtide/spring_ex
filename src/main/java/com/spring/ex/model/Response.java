package com.spring.ex.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.ex.common.BaseObject;

/**
 * Controller가 반환하는 응답 기본 클래스
 * code 이외의 다른 정보가 응답에 들어가야 할 경우 이 클래스를 상속받아
 * 사용한다.
 * @author 양명권 (mg.yang@campmobile.com)
 * @see ResponseCode
 */
public class Response extends BaseObject {
	private static final long serialVersionUID = -3464431363246170015L;

	public static final Response SUCCESS = new Response();
	public static final Response FAIL = new Response();
	public static final Response BAD_PARAMETER = new Response();
	public static final Response CONFIRM = new Response();

	static {
		SUCCESS.setCode(ResponseCode.SUCCESS);
		FAIL.setCode(ResponseCode.FAIL);
		BAD_PARAMETER.setCode(ResponseCode.BAD_PARAMETER);
		CONFIRM.setCode(ResponseCode.CONRIFM);
	}

	private ResponseCode code = ResponseCode.SUCCESS;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	private String message;

	public static Response FAIL(String message) {
		return new Response(ResponseCode.FAIL, message);
	}

	public Response() {
	}

	public Response(ResponseCode code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResponseCode getCode() {
		return code;
	}

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
