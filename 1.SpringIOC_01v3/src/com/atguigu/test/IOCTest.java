package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.bean.Person;


public class IOCTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
	
//--------------------------------------------------------------	
	
	/**
	 * 实验2：根据bean的类型从IOC容器中获取bean的实例
	 * 
	 * 如果ioc容器中这个类型的bean有多个，查找就会报错
	 * org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	 * No qualifying bean of type [com.atguigu.bean.Person] is defined: 
	 * expected single matching bean but found 2: person01,person02
	 * 
	 */
	@Test
	public void test02() {
		
		//实验2：根据bean的类型从IOC容器中获取bean的实例
/*		Person bean = ioc.getBean(Person.class);
		System.out.println(bean);*/
		
		Person bean2 = ioc.getBean("person02",Person.class);
		System.out.println(bean2);
		
		//实验3：通过构造器为bean的属性赋值（index,type属性介绍）（测试）
		//通过p名称空间为bean赋值
		Object bean3 = ioc.getBean("person03");
		System.out.println(bean3);	
		
		Object bean4 = ioc.getBean("person04");
		System.out.println(bean4);	
		
		Object bean5 = ioc.getBean("person05");
		System.out.println(bean5);	
		
		Object bean6 = ioc.getBean("person06");
		System.out.println(bean6);	
		
		/*
		 * 实验4：正确的为各种属性赋值
		 * 测试使用null值 、
		 * 引用类型赋值（引用其他bean、引用内部bean）（测试）
		 * 集合类型赋值（List、Map、Properties）、(测试)
		 * util名称空间创建集合类型的bean
		 * 级联属性赋值
		*/
		
		
	}
	
//--------------------------------------------------------------
	
	/**
	 * 从容器中拿到这个组件
	 */

	
	/**
	 * 存在的几个问题：
	 * 1）、src，源码包开始的路径，称为类路径的开始；
	 *		所有源码包里面的东西都会被合并放在类路径里面；
	 *		Java：/bin/
	 *		web:/WEB-INF/classes/
	 * 2）、导包，特别注意commons-logging-1.1.3.jar（依赖）
	 * 3）、先导包再创建配置文件；
	 * 4）、Spring的容器接管了标志了s的类；
	 */
	/**
	 * 几个细节：
	 * 1）、ApplicationContext（IOC容器的接口）
	 * 2）、给容器中注册一个组件；我们也从容器中按照id拿到了这个组件的对象？
	 * 		组件的创建工作，是容器完成；
	 * 		Person对象是什么时候创建好了呢？
	 * 		容器中对象的创建在容器创建完成的时候就已经创建好了；
	 * 3）、同一个组件在ioc容器中是单实例的；容器启动完成都已经创建准备好的；
	 * 4)容器中如果没有这个组件，获取组件？报异常
	 * org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'person03' is defined	
	 * 5)ioc容器在创建这个组件对象的时候，（property）会利用setter方法为javaBean的属性进行赋值；
	 * 6）javaBean的属性名是由什么决定的？getter/setter方法是属性名；set去掉后面那一串首字母小写就是属性名；
	 * 		private String lastName;？（不是）
	 * 		所有getter/setter都自动生成
	 */

	@Test
	public void test() {
		//ApplicationContext：代表ioc容器
		//ClassPathXmlApplicationContext：当前应用的xml配置文件在ClassPath下
		//根据spring的配置文件得到ioc容器对象	
		ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
		//容器帮我们创建好对象了；
//		System.out.println("容器启动完成……");//容器中对象的创建在容器创建完成的时候就已经创建好了
		Person bean = (Person) ioc.getBean("person01");
		System.out.println(bean);
/*		Object bean2 = ioc.getBean("person01");//同一个组件在ioc容器中是单实例的
		System.out.println(bean == bean2);
		System.out.println("============");
		Object bean3 = ioc.getBean("person03");//错误示范，ioc容器中没有这个组件
		*/
	}

}
