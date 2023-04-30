package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.NewsModel;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delete(long [] ids);
	List<NewsModel> findAll();
}
