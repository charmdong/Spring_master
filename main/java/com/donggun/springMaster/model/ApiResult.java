package com.donggun.springMaster.model;

public class ApiResult<T> {
	
	private T data;
	
	private String error;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ApiResult() {/* empty */}

	
	public ApiResult(T data) {
		super();
		this.data = data;
	}

	public ApiResult(T data, String error) {
		this.data = data;
		this.error = error;
	}
	

	public static <T> ApiResult<T> succeed(T data) {
		ApiResult<T> result = new ApiResult<>(data);
		result.error = null;
		return result;
	}
	
	public static <T> ApiResult<T> failed(String error) {
		ApiResult<T> result = new ApiResult<>();
		
		result.data = null;
		result.error = error;
		
		return result;
	}
	
}
