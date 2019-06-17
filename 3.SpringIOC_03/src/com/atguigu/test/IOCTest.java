package com.atguigu.test;

import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.service.BookService;
import com.atguigu.servlet.BookServlet;


/**
 * 
 * @author costuol
 * 使用Spring的单元测试：
 * 1、导包：Spring单元测试包spring-test-4.0.0.RELEASE.jar
 * 2、 @ContextConfiguration(locations="")使用它来指定Spring的配置文件的位置
 * 3、指定用哪种驱动进行单元测试，默认就是junit
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 *		使用Spring的单元测试模块来执行标了@Test注解的测试方法；
 *		以前@Test注解只是由junit执行
 * 好处，不用ioc.getBean()获取组件了；直接Autowired组件。Spring为我们自动装配；
 */
@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest {
	
//	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

	ApplicationContext ioc = null;
	
	@Autowired
	BookServlet bookServlet;
	@Autowired
	BookService bookService;
	
	@Test
	public void test03() {
		System.out.println("bookServlet");
		System.out.println("bookService");
	}
	
	@Test
	public void test02v1() {

	}
	
	@Test
	public void test02() {
		BookServlet bookServlet = ioc.getBean(BookServlet.class);
		bookServlet.doGet();
	}
	
	
	
	/**
	 * Caused by: java.lang.NoClassDefFoundError: org/springframework/aop/TargetSource
	 * Caused by: java.lang.ClassNotFoundException: org.springframework.aop.TargetSource
	 * 
	 * 使用注解加入到容器中的组件，和使用配置加入到容器中的组件行为都是默认一样的
	 * 1、组件的id。默认就是组件的类名首字母小写
	 * 				@Repository("bookdaohaha")//在注解中指定id
	 * 				public class BookDao {}
	 * 
	 * 2、组件的作用域，默认就是单例的
	 * 				@Scope(value="prototype")//添加Scope注解，变成多实例
	 * 
	 */
	@Test
	public void test() {
		Object bean = ioc.getBean("bookDao");
		Object bean2 = ioc.getBean("bookDao");
		System.out.println(bean == bean2);
	}

}
