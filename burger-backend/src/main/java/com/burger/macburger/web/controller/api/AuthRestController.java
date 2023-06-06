package com.burger.macburger.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.burger.macburger.domain.user.User;
import com.burger.macburger.service.auth.PrincipalDetailsService;
import com.burger.macburger.web.dto.CMRespDto;
import com.burger.macburger.web.dto.user.UserSignupReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthRestController {

	private User user;
	private final PrincipalDetailsService principalDetailsService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserSignupReqDto userSignupReqDto) {
		boolean status = false;
		
		System.out.println("test");
		System.out.println("test1234124");
		
		try {
			status = principalDetailsService.addUser(userSignupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "회원가입 실패", status));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "회원가입 성공", status));
	}
}
