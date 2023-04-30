package com.laptrinhweb.mapper;

import java.sql.ResultSet;

import com.laptrinhweb.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel categoryModel =new CategoryModel();
		try {
			categoryModel.setId(resultSet.getLong("id"));
			categoryModel.setCode(resultSet.getString("code"));
			categoryModel.setName(resultSet.getString("name"));
			return categoryModel;
		} catch (Exception e) {
			return null;
		}
		
		
	}

}
