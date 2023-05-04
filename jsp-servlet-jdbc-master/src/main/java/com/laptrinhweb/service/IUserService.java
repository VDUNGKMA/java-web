package com.laptrinhweb.service;

import com.laptrinhweb.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndStatus(String userName,String Password,int status);
}
