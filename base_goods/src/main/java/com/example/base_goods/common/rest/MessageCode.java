package com.example.base_goods.common.rest;

/**
 * @author vicky
 * @date 2019/5/27
 */
public enum MessageCode {

	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),

	/**
	 * 系统错误
	 */
	SYSTEM_ERROR(201, "系统异常"),

	/**
	 * 授权失败
	 */
	NO_AUTH(202, "授权失败"),

	/**
	 * 参数错误
	 */
	PARAMS_ERROR(301, "参数错误"),

	/**
	 * 用户不存在
	 */
	USER_NOT_EXIST(302, "用户信息不存在"),

	USER_PASSWORD_ERROR(303, "密码不正确"),

	/**
	 * 数据库保存失败
	 */
	INSERT_FAIL(304, "数据库保存失败");


	MessageCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private Integer code;

	private String msg;

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}