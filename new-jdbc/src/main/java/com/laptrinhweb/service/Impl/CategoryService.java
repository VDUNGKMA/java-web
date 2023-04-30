package com.laptrinhweb.service.Impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDao CategoryDao;
	@Override
	public List<CategoryModel> findAll() {
		
	 return CategoryDao.FindAll();
	}
	
}
