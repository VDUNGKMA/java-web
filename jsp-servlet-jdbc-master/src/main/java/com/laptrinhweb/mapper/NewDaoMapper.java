package com.laptrinhweb.mapper;

import java.sql.ResultSet;

import com.laptrinhweb.model.NewsModel;

public class NewDaoMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		NewsModel news =new NewsModel();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setCategoryId(resultSet.getLong("categoryId"));
			news.setContent(resultSet.getString("content"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if(resultSet.getTimestamp("modifieddate")!= null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if(resultSet.getString("modifiedby")!= null) {
				news.setModifiedBy(resultSet.getString("modifiedby"));
			}
			return news;
			
		} catch (Exception e) {
			return null;
		}
		
		
	}

}
