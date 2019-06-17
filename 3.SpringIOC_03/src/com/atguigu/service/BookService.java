package com.atguigu.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.Dao.BookDao;

@Service
public class BookService {
	
//	@Autowired
	@Resource
	private BookDao bookDao;
	

	public void save() {
		System.out.println("bookService>..正在调用dao帮你保存图书...");
		bookDao.saveBook();
	}
	
}
