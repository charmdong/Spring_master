package com.donggun.springMaster.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("Hello")
public class HelloController {
	
	@RequestMapping(value= {"/main", "/index"})
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello everyone!");
		return "hello";
	}
	
	// @PathVariable Test
	@RequestMapping("/multiple/{number}")
	public String multipleTen(@PathVariable("number") int number, Model model) {
		model.addAttribute("multipleTen", number * 10);
		return "multiple";
	}
	
	// @RequestParam Test
	@RequestMapping("/detail")
	public String detail(@RequestParam(value="id", required=true, defaultValue="admin") String requestParam, Model model) throws IOException {
		if(requestParam == null) {
			return "redirect:/";
		}
		
		model.addAttribute("detailInfo", "This is Detail Information");
		model.addAttribute("requestParam", requestParam);
		return "detail";
	}
	
}
