package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.IUserDao;
import com.laptrinhweb.mapper.UserMapper;
import com.laptrinhweb.model.UserModel;

public class UserDao extends AbstractDao<UserModel> implements IUserDao{


	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String Password, int status) {
		StringBuilder sql =new StringBuilder("SELECT * FROM user as A ");
		sql.append("join role AS B ON A.roleid=B.id  ");
		sql.append("WHERE username=? AND password=? AND status=?");
		List<UserModel> users=query(sql.toString(), new UserMapper(), userName,Password,1);
		return users.isEmpty() ? null : users.get(0);
	}

}
