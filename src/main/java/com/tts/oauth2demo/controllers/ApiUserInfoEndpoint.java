package com.tts.oauth2demo.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiUserInfoEndpoint {
	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal){
		Map<String,Object> map = new HashMap();
		map.put("login", principal.getAttribute("login"));
		map.put("given_name", principal.getAttribute("given_name"));
		System.out.println(map);

		return map;
	}
}
