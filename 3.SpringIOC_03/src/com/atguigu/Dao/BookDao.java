package com.atguigu.Dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * id默认就是类名首字母小写
 * @author costuol
 *
 */
//@Repository("bookdaohaha")在注解中指定id
@Repository
//@Scope(value="prototype")
public class BookDao {
	
/*	@Autowired
	private DataSource dataSource;*/
	
	public void saveBook() {
//		dataSource.getConnection();
		System.out.println("图书已经保存……");
	}
}
