/*
 *  Copyright (c) 2019 ZHAW School of Engineering. All rights are reserved.
 */
package ch.zhaw.soe.eicw.webserver;

/**
 * Common HTTP status codes. 
 */
public enum Status {
	OK(200, "OK"), FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Not Found"), NOT_IMPLEMENTED(
			501, "Not Implemented");

	private int code;
	private String message;

	private Status(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
