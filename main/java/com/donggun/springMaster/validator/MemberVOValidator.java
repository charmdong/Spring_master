package com.donggun.springMaster.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.donggun.springMaster.dto.MemberVO;

/**
 * MemberVO 커맨드 객체 값 검증을 위함 
 * @author donggun.Chung
 * @since 2021.04.19.
 * @version 1.0
 */
public class MemberVOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// MemberVOValidator 클래스가 MemberVO 타입의 객체를 지원하도록 설정
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberVO member = (MemberVO) target;
		
		// name에 해당하는 값이 비어있거나 공백인 경우 에러 코드를 설정한다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		
		String password = member.getPassword();
		String confirmPassword = member.getConfirmPassword();
		
		if(password != null) {
			password = password.trim();
			
			if(confirmPassword != null) {
				confirmPassword = confirmPassword.trim();
				
				if(password.length() < 5) {
					errors.rejectValue("password", "shortPassword");
				}
				else if(!password.equals(confirmPassword)) {
					errors.rejectValue("confirmPassword", "notSame");
				}
			}
		}
		
	}

}
