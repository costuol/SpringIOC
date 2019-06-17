package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;


@Service
public class BookService extends BaseService<Book>{
	
/*	@Autowired
	BookDao bookDao;
	public void save() {
		bookDao.save();
	}*/
}
