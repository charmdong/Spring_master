package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.dto.MemberVO;

/**
 * @author donggun.Chung
 * @since 2021.04.17.
 * @version 1.0
 */
@RequestMapping("/member")
@Controller("Member")
public class MemberController {

	@RequestMapping("/login")
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
	
	// 커맨드 객체 Test 
	@RequestMapping("/regist")
	public String memberRegist(MemberVO member) {
		return "member/detail";
	}
}
