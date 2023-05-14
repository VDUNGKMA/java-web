package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.model.CategoryModel;

public interface ICategoryDao  extends IGenericDao{
	 List<CategoryModel> FindAll();
	 CategoryModel findOne(long id);
	 CategoryModel findOneByCode(String code);
}
