package com.laptrinhweb.service.Impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhweb.dao.ICategoryDao;
import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.model.CategoryModel;
import com.laptrinhweb.model.NewsModel;
import com.laptrinhweb.paging.Pageble;
import com.laptrinhweb.service.INewService;

public class NewService implements INewService{

	@Inject //cơ chế không phải khởi tạo đối tượng new mới mà sử dụng luôn
	private INewDao NewDao;
	@Inject
	private ICategoryDao categoryDao;
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return NewDao.FindByCategoryId(categoryId);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category =categoryDao.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(category.getId());
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
		CategoryModel category =categoryDao.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(category.getId());
		updateNews.setModifiedBy("");
		NewDao.update(updateNews);
		return NewDao.findOne(updateNews.getId());
	}
	@Override
	public void delete(long[] ids) {
		
		for(long id:ids) {
			NewDao.delete(id);
		}
	}
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		
		return NewDao.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
	
		return NewDao.getTotalItem();
	}

	@Override
	public NewsModel findOne(long id) {
		NewsModel newsModel=NewDao.findOne(id);
		CategoryModel categoryModel =categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
