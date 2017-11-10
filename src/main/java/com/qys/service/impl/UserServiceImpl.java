package com.qys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qys.dao.UserMapper;
import com.qys.pojo.User;
import com.qys.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User getUserByNameAndPwd(User user) {
		// TODO Auto-generated method stub
		return mapper.getUserByNameAndPwd(user);
	}

}
