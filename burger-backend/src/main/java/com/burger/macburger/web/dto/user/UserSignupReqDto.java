package com.burger.macburger.web.dto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.burger.macburger.domain.user.User;

import lombok.Data;

@Data
public class UserSignupReqDto {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private String userId;
	private String userPassword;
	private String name;
	private String userBirth;
	private String userPhone;
	private String userGender;
	private boolean privacyAgreement;
	private boolean phoneAgreement;
	
	public User userEntity() {
		return User.builder()
				.user_id(userId)
				.user_password(passwordEncoder.encode(userPassword))
				.user_name(name)
				.user_birth(userBirth)
				.user_phone(userPhone)
				.user_gender(userGender)
				.user_roles("ROLE_USER")
				.privacy_agreement(privacyAgreement)
				.phone_agreement(phoneAgreement)
				.build();
	}
	
}
