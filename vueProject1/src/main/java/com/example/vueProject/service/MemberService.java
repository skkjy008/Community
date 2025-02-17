package com.example.vueProject.service;

import org.springframework.stereotype.Service;

import com.example.vueProject.dto.RegisterRequest;
import com.example.vueProject.entity.Member;

@Service
public interface MemberService {

	Member registerMember(RegisterRequest request);
	

}
