package com.donggun.springMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("Hello")
public class HelloController {
	
	
	// @PathVariable Test
	@RequestMapping("/multiple/{number}")
	public String multipleTen(@PathVariable("number") int number, Model model) {
		model.addAttribute("multipleTen", number * 10);
		return "multiple";
	}
	
}
