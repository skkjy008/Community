package com.example.vueProject.service;

import org.springframework.stereotype.Service;

@Service
public class Userservice {
	
    // 임시로 하드코딩된 사용자 정보
    public boolean authenticate(String username, String password) {
        // 실제 구현에서는 데이터베이스에서 사용자 정보를 검증해야 합니다.
        return "admin".equals(username) && "password".equals(password);
    }

}
