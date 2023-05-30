package com.burger.macburger.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
	public int save(User user) throws Exception;
	
	public User findByUserByUsername(String username) throws Exception;
}
