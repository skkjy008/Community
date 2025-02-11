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
import com.example.vueProject.service.Userservice;
import com.example.vueProject.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class MainController {
	

	private final Userservice userservice;
	
	public MainController(Userservice userservice)
	{
		this.userservice = userservice;
	}
	
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // 간단한 사용자 검증 (실제 구현에서는 DB 검증)
        if (userservice.authenticate(request.getUsername(), request.getPassword())) {
            String token = JwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
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
