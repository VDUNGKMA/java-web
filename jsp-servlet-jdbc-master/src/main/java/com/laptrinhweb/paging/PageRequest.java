package com.laptrinhweb.paging;

import com.laptrinhweb.sort.Sorter;

public class PageRequest implements Pageble {
	
	private int page;
	private int maxPageItem;
	private Sorter sorter;
	 public PageRequest(int page,int maxPageItem,Sorter sorter) {
		this.page=page;
		this.maxPageItem=maxPageItem;
		this.sorter=sorter;
	}
	@Override
	public int getPage() {
		
		return this.page;
	}

	@Override
	public int getOffset() {
		return (this.page -1) * this.maxPageItem;
	}

	@Override
	public int getLimit() {
		
		return this.maxPageItem;
	}
	@Override
	public Sorter getSorter() {
		if(this.sorter != null) {
			return this.sorter;
		}
		return null;
	}
	 

}
