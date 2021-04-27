package com.donggun.springMaster.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.donggun.springMaster.validator.MemberVOValidator;
import com.donggun.springMaster.vo.MemberVO;

/**
 * @author donggun.Chung
 * @since 2021.04.17.
 * @version 1.0
 */
@RequestMapping("/member")
@Controller("Member")
@SessionAttributes("userInfo")
public class MemberController {

	
	@ModelAttribute("userInfo")
	public MemberVO userData() {
		return new MemberVO();
	}
	
	/**
	 * 로그인 form
	 * @return view name
	 */
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/login";
	}
	
	/**
	 * 로그인
	 * @param member
	 * @return view name
	 */
	@RequestMapping("/login")
	public String memberLogin(@ModelAttribute("userInfo") MemberVO member) {
		// TODO validate id, password
		// TODO cookie 설정
		return "redirect:/index";
	}
	
	/**
	 * 로그아웃
	 * @param sessionStatus
	 * @return view name
	 */
	@RequestMapping("/logout")
	public String memberLogout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		
		return "redirect:/index";
	}
	
	/**
	 * 사용자 목록 조회 
	 * @return view name
	 */
	@RequestMapping("/list")
	public String memberList() {
		return "member/list";
	}
	
	/**
	 * 사용자 정보 상세 조회
	 * @param id
	 * @param model
	 * @return view name
	 */
	@RequestMapping("/detail")
	public String memberDetail(@RequestParam(value="id", required=true, defaultValue="admin") String id, Model model) {
		return "member/detail";
	}
	
	/**
	 * 사용자 등록
	 * @return view name
	 */
	@RequestMapping("/registForm")
	public String registForm() {
		return "member/join";
	}
	
	/**
	 * 사용자 정보 수정폼 
	 * @param id
	 * @param model
	 * @return view
	 */
	@RequestMapping("/modifyForm/{id}") 
	public String modifyForm(@PathVariable("id") String id, Model model) {
		// TODO MemberVO memberInfo = MemberService.getMemberInfo(id);
		// model.addAttribute("memberInfo", memberInfo);
		
		return "member/join";
	}
	
	/**
	 * 사용자 정보 수정
	 * @param member
	 * @param errors
	 * @return view name
	 */
	@RequestMapping("/modify")
	public String memberModify(@Valid @ModelAttribute("memberInfo") MemberVO member, Errors errors) {
		if(errors.hasErrors()) {
			return "member/detail";	
		}
		
		return "member/index";
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
