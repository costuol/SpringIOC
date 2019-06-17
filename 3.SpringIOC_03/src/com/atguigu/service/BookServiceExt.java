package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.Dao.BookDao;

@Service
public class BookServiceExt extends BookService {
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void save() {
		System.out.println("bookServiceExt……");
	}
}
