package com.laptrinhweb.service;

import java.util.List;

import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.paging.Pageble;

public interface INewService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel newsModel);
	void delete(long [] ids);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();
	NewsModel findOne(long id);
}
