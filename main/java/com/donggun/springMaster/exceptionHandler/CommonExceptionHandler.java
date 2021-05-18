package com.donggun.springMaster.exceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 공통 컨트롤러 요청 익셉션 핸들러
 * @author donggun.Chung
 * @since 2021.04.27.
 * @version 1.0
 */
@ControllerAdvice("com.donggun.springMaster.controller")
public class CommonExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class) 
	public String handleRuntimeException() {
		return "error/runtimeException";
	}
	
}
