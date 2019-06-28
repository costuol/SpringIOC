package com.atguigu.test;

import static org.junit.Assert.*;



import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.impl.MyMathCalculator3;
import com.atguigu.inter.Calculator;

/**
 * Spring基础包：
 * commons-logging-1.1.3.jar
 * spring-aop-4.0.0.RELEASE.jar
 * spring-beans-4.0.0.RELEASE.jar
 * spring-context-4.0.0.RELEASE.jar
 * spring-core-4.0.0.RELEASE.jar
 * spring-expression-4.0.0.RELEASE.jar
 * 
 * Spring支持面向切面编程的包是：
 * spring-aspects-4.0.0.RELEASE.jar：基础版
 * 加强版的面向切面编程（即使目标对象没有实现任何接口也能创建动态代理）
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * 
 * 
 * @author costuol
 *
 */
public class AOPTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void test4() {
		MyMathCalculator3 Bean = ioc.getBean(MyMathCalculator3.class);
		Bean.div(4, 2);
/*		System.out.println("————————————");
		Bean.add(2, 4);
		System.out.println("————————————");
		Bean.div(4, 0);*/
	}
}
