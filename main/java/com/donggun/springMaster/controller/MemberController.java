package com.donggun.springMaster.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.dto.MemberVO;
import com.donggun.springMaster.validator.MemberVOValidator;

/**
 * @author donggun.Chung
 * @since 2021.04.17.
 * @version 1.0
 */
@RequestMapping("/member")
@Controller("Member")
public class MemberController {

	@RequestMapping("/loginForm")
	public String memberLogin() {
		return "member/login";
	}
	
	@RequestMapping("/list")
	public String memberList() {
		return "member/list";
	}
	
	@RequestMapping("/detail")
	public String memberDetail(@RequestParam(value="id", required=true, defaultValue="admin") String id, Model model) {
		return "member/detail";
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		return "member/join";
	}
	
	@RequestMapping("/modify")
	public String memberModify(@Valid @ModelAttribute("memberInfo") MemberVO member, Errors errors) {
		if(errors.hasErrors()) {
			return "member/join";	
		}
		
		return "member/detail";
	}
	
	/**
	 * 커맨드 객체 Test
	 * 전달인자로 커맨드 객체 뒤에 바로 Errors나 BindingResult가 위치해야 한다.
	 * @Valid annotation 적용
	 * 
	 * @param member
	 * @param errors
	 */
	@RequestMapping("/regist")
	public String memberRegist(@Valid @ModelAttribute("memberInfo") MemberVO member, Errors errors) {
		// 커맨드 객체 값 검증
		// new MemberVOValidator().validate(member, errors);
		if(errors.hasErrors()) {
			return "member/join";
		}
		
		// TODO Service BL
		
		return "member/detail";
	}
	
	/**
	 * 폼과 커맨드 객체를 매핑해주는 WebDataBinder를 초기화
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MemberVOValidator());
	}
}
