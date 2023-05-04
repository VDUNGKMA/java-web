package com.laptrinhweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhweb.model.RoleModel;
import com.laptrinhweb.model.UserModel;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user =new UserModel();
		try {
			user.setId(resultSet.getLong("id"));
			user.setUserName(resultSet.getString("userName"));
			user.setFullName(resultSet.getString("fullName"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			RoleModel role =new RoleModel();
			role.setCode(resultSet.getString("code"));
			role.setName(resultSet.getString("name"));
			return user;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
