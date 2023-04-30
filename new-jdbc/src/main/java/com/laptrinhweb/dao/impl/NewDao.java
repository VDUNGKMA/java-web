package com.laptrinhweb.dao.impl;

import java.util.List;

import com.laptrinhweb.dao.INewDao;
import com.laptrinhweb.mapper.NewDaoMapper;
import com.laptrinhweb.model.NewsModel;

public class NewDao extends AbstractDao<NewsModel> implements INewDao{
	
	@Override
	public List<NewsModel> FindByCategoryId(Long categoryId) {
		
		String sql="SELECT * FROM news WHERE categoryId =?";
		return query(sql, new NewDaoMapper(), categoryId);
		
	}

	@Override
	/*ưu điểm của việc dùng stringbuider thay vì string là do khi khởi tạo nó chỉ khởi tạo 1 vùng nhớ cho để lưu dữ liệu 
	thay vì khởi tạo nhiều vùng nhớ để lưu dữ liệu như string */
	public Long save(NewsModel newsModel) {
		StringBuilder sql=new StringBuilder("INSERT INTO news(title,content, ");
		sql.append(" thumbnail,shortdescription,categoryid,createddate,createdby) ");
		sql.append("VALUES(?,?,?,?,?,?,?)");
		return insert(sql.toString(), newsModel.getTitle(),newsModel.getContent(),newsModel.getThumbnail(),newsModel.getShortDescription()
				,newsModel.getCategoryId(),newsModel.getCreatedDate(),newsModel.getCreatedBy());
		
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql="SELECT * FROM news WHERE id =?";
		List<NewsModel> news=query(sql, new NewDaoMapper(), id);
		
		return (news.isEmpty()) ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql=new StringBuilder(" UPDATE news SET title=?, thumbnail=?,");
		sql.append("shortdescription=?,content=?,categoryid=?,");
		sql.append("createddate=?,createdby=?,modifieddate=?,modifiedby=? WHERE id= ?");
		update(sql.toString(),updateNews.getTitle(),updateNews.getThumbnail(),updateNews.getShortDescription(),updateNews.getContent(),
				updateNews.getCategoryId(),updateNews.getCreatedDate(),updateNews.getCreatedBy(),updateNews.getModifiedDate(),
				updateNews.getModifiedBy(),updateNews.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql="DELETE FROM news where id=?";
		update(sql,id);
		
	}

	@Override
	public List<NewsModel> findAll() {
		String sql="SELECT * FROM news";
		return query(sql, new NewDaoMapper());
		
	}

}
