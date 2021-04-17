package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.donggun.springMaster.dto.MemberVO;

@RequestMapping("/member")
@Controller
public class MemberController {

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
		return "member/registForm";
	}
	
	// 커맨드 객체 Test 
	@RequestMapping("/regist")
	public String memberRegist(MemberVO member) {
		return "member/detail";
	}
}
