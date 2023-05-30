package com.burger.macburger.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private int user_code;
	
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_birth;
	private String user_phone;
	private String user_gender;
	
	private String user_roles;
	
	private boolean privacy_agreement;
	private boolean phone_agreement;
	
	private LocalDateTime create_date;
	private LocalDateTime update_date;
	
	
	public List<String> getUserRoles() {
		if(user_roles == null || user_roles.isBlank()) {
			return new ArrayList<String>();
		}
		return Arrays.asList(user_roles.replaceAll(" ", "").split(","));
	}
}
