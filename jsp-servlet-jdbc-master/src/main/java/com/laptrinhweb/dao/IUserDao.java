package com.laptrinhweb.dao;

import com.laptrinhweb.model.UserModel;

public interface IUserDao extends IGenericDao<UserModel> {
	UserModel findByUserNameAndPasswordAndStatus(String userName,String Password,int status);
}
