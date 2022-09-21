package com.tts.oauth2demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
	@GetMapping(path = "/")
	public String redirectHome() {
		return "redirect:/index.html"; //don't put space with redirect bc it wont work
	}
	
}
