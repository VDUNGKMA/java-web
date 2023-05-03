package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.model.CategoryModel;

public class CategoryDao extends AbstractDao implements ICategoryDao {
	
	
	@Override
	public List<CategoryModel> FindAll() {
		String sql="SELECT * FROM Category";
		return query(sql, new CategoryMapper());
		
		
	}
	

}
