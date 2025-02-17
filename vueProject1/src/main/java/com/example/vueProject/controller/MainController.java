package com.example.vueProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vueProject.dto.AuthResponse;
import com.example.vueProject.dto.LoginRequest;
import com.example.vueProject.dto.RegisterRequest;
import com.example.vueProject.entity.Member;
import com.example.vueProject.service.MemberService;
import com.example.vueProject.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class MainController {
	
	@Autowired
	private final MemberService memberservice;
	
	public MainController(MemberService memberservice)
	{
		this.memberservice = memberservice;
	}
	

	@PostMapping("/register")
	public ResponseEntity<String> registerMember(@RequestBody RegisterRequest request)
	{
		Member member = memberservice.registerMember(request);
		return ResponseEntity.ok("계정 생성이 완료되었습니다."+member.getUsername());
	}
    
    @GetMapping("/success")
    public String success()
    {
		return "인증 성공";
    	
    }
    
    @GetMapping("/")
    public String start()
    {
    	return "시작 페이지입니다.";
    }
    
}
