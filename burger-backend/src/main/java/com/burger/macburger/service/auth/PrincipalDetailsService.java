package com.burger.macburger.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.burger.macburger.domain.user.User;
import com.burger.macburger.domain.user.UserRepository;
import com.burger.macburger.web.dto.user.UserSignupReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEntity = null;
		
		 try {
			userEntity = userRepository.findByUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(username);
		}
		 
		return new PrincipalDetails(userEntity);
	}
	
	public boolean addUser(UserSignupReqDto userSignupReqDto) throws Exception {
		log.info("userEntity" + userSignupReqDto.userEntity());
		return userRepository.save(userSignupReqDto.userEntity()) > 0;
	}

}
