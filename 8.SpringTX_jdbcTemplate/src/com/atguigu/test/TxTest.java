package com.atguigu.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TxTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
	
	/**
	 * 实验3：批量插入
	 */	
	@Test
	public void test03() {
		String sql = "INSERT into employee(emp_name,salary) VALUES(?,?)";
		//List<Object[]>
		//List的长度就是sql语句要执行的次数
		//Object[],每次执行要用的参数
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"张三",998.89});
		batchArgs.add(new Object[] {"李四",2342.45});
		batchArgs.add(new Object[] {"王五",1008.60});
		batchArgs.add(new Object[] {"孙六",4939.06});
		int[] is = jdbcTemplate.batchUpdate(sql, batchArgs);
		for (int i : is) {
		System.out.println("更新员工："+ i);
		}
	}
	
	/**
	 * 实验2：将emp_id=5的记录的salary字段更新为1300.00
	 */	
	@Test
	public void test02() {
		String sql = "UPDATE employee SET salary=? WHERE emp_id=?";
		int update = jdbcTemplate.update(sql,1300.00,5);
		System.out.println("更新员工："+update);
	}
	
	@Test
	public void test() throws SQLException {
		DataSource bean = ioc.getBean(DataSource.class);
		Connection connection = bean.getConnection();
		System.out.println(connection);
		connection.close();	
	}

	
	@Test
	public void test01() throws SQLException {
/*		DataSource bean = ioc.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(bean);*/
		System.out.println(jdbcTemplate);
	}
}
