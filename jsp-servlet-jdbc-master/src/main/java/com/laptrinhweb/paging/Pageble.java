package com.laptrinhweb.paging;

import com.laptrinhweb.sort.Sorter;

public interface Pageble {
	int getPage();
	int getOffset();
	int getLimit();
	Sorter getSorter();
}
