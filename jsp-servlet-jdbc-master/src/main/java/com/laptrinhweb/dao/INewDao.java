package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.paging.Pageble;

public interface INewDao  extends IGenericDao<NewsModel>{
	NewsModel findOne(Long id);
	List<NewsModel> FindByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void update (NewsModel updateNews);
	void delete(long id);
	List<NewsModel> findAll(Pageble pageble);
	int getTotalItem();	
}
