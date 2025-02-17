package com.example.vueProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.vueProject.dto.RegisterRequest;
import com.example.vueProject.entity.Member;
import com.example.vueProject.repository.MemberRepository;
import com.example.vueProject.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberrepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Member registerMember(RegisterRequest request) {
		Member member = new Member(
				request.getUsername(),
				request.getNickname(),
				request.getEmail(),
				passwordEncoder.encode(request.getPassword())
				);
		return memberrepository.save(member);
	}
	

}
