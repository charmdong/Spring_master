package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello everyone!");
		return "hello";
	}
}
