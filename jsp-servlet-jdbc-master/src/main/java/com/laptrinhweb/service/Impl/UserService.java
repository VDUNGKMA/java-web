package com.laptrinhweb.service.Impl;

import javax.inject.Inject;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDao userDao;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String Password, int status) {
		
		return userDao.findByUserNameAndPasswordAndStatus(userName, Password, status);
	}

}
