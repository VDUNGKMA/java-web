package com.laptrinhweb.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.service.INewService;

public class NewService implements INewService{

	@Inject //cơ chế không phải khởi tạo đối tượng new mới mà sử dụng luôn
	private INewDao NewDao;
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return NewDao.FindByCategoryId(categoryId);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newId= NewDao.save(newsModel);
		return NewDao.findOne(newId); 
	}
	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews=NewDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		NewDao.update(updateNews);
		return null;
	}
	@Override
	public void delete(long[] ids) {
		
		for(long id:ids) {
			NewDao.delete(id);
		}
	}
	@Override
	public List<NewsModel> findAll() {
		
		return NewDao.findAll();
	}

}
