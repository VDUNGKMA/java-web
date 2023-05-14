package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.mapper.CategoryMapper;
import com.laptrinhweb.mapper.NewDaoMapper;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewsModel;

public class CategoryDao extends AbstractDao implements ICategoryDao {
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryModel> FindAll() {
		String sql="SELECT * FROM Category";
		return query(sql, new CategoryMapper());
				
	}

	@Override
	public CategoryModel findOne(long id) {
		String sql="SELECT * FROM category WHERE id =?";
		@SuppressWarnings("unchecked")
		List<CategoryModel> category=query(sql, new CategoryMapper(), id);
		
		return (category.isEmpty()) ? null : category.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql="SELECT * FROM category WHERE code =?";
		@SuppressWarnings("unchecked")
		List<CategoryModel> category=query(sql, new CategoryMapper(), code);

		return (category.isEmpty()) ? null : category.get(0);
	}


}
