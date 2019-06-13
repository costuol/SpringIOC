package com.atguigu.test;

import java.util.List;
import java.util.Map;
import java.util.Properties;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.atguigu.bean.Book;
import com.atguigu.bean.Car;
import com.atguigu.bean.Person;



public class IOCTest {
	
//--------------------------------------------------------------
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
	
	@Test
	public void test10() {
		// TODO Auto-generated method stub
  		Object bean = ioc.getBean("myFactoryBeanImple");
		System.out.println(bean);

	}	
	
	@Test
	public void test09() {
		// TODO Auto-generated method stub
  		Object bean = ioc.getBean("airPlane01");
  		Object bean2 = ioc.getBean("airPlane02");
		System.out.println(bean);
		System.out.println(bean2);
		System.out.println("容器启动完成");
	}	
	
	
	@Test
	public void test08() {
		// TODO Auto-generated method stub
		System.out.println("容器启动完成");
		
  		Object bean = ioc.getBean("book");
		Object bean2 = ioc.getBean("book");
		System.out.println(bean == bean2);
	}
	
//--------------------------------------------------------------	
	
	
//	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");		
	

/*	实验6：通过继承实现bean配置信息的重用(测试)
	实验7：通过abstract属性创建一个模板bean*/
	
	@Test
	public void test07() {
//		Person person05 = (Person) ioc.getBean("person05");
/*		org.springframework.beans.factory.BeanIsAbstractException: 
		Error creating bean with name 'person05': 
		Bean definition is abstract*/

		Person person06 = (Person) ioc.getBean("person06");
		System.out.println("person06："+person06);
	}	
	
	
	/**
	 * 级联属性可以修改属性的属性，注意：原来bean的值可能会被修改
	 */
	@Test
	public void test06() {
		Person person04 = (Person) ioc.getBean("person04");
		Object car = ioc.getBean("car01");
		System.out.println("容器中的car："+car);
		System.out.println("person中的car："+person04.getCar());
		
	}
	
	
	
//--------------------------------------------------------------	
	

	/**
	 * 实验4：正确的为各种属性赋值
	 * 			测试使用null值 、默认引用类型就是null；基本类型是默认值
	 */

	@Test
	public void test05() {
		Person person03 = (Person) ioc.getBean("person03");
		Map<String, Object> maps = person03.getMaps();
		System.out.println(maps);
		
//		Object bean = ioc.getBean("myMap");
		Map<String, Object> bean = (Map<String, Object>) ioc.getBean("myMap");
		System.out.println(bean.getClass());
		
	}
	
	@Test
	public void test04() {
		// TODO Auto-generated method stub
		Person person01 = (Person) ioc.getBean("person01");			
		Person person02 = (Person) ioc.getBean("person02");	
		
		Car car = person01.getCar();
		System.out.println(car);
		
		
		List<Book> books = person02.getBooks();
		System.out.println(books);
		
		System.out.println("-------------");
		
		Map<String, Object> maps = person02.getMaps();
		System.out.println(maps);
		System.out.println(person02.getProperties());
		
		
		/**
		 * 内部bean是不能用id获取的		
		 * org.springframework.beans.factory.NoSuchBeanDefinitionException: 
		 * No bean named 'carInner' is defined
		 */
		//内部bean不能被ioc直接获取到，只能内部使用
		try {
			Object bean = ioc.getBean("carInner");
			System.out.println(bean);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("No bean named 'carInner' is defined");
		}
		
/*		
		org.springframework.beans.factory.BeanCreationException: 
			Error creating bean with name 'person02' defined in class path resource [ioc2.xml]: 
			Initialization of bean failed; nested exception is org.springframework.beans.ConversionNotSupportedException: 
			Failed to convert property value of type 'java.util.LinkedHashMap' to required type 'com.sun.javafx.collections.MappingChange$Map' for property 'maps'; nested exception is java.lang.IllegalStateException: 
			Cannot convert value of type [java.util.LinkedHashMap] to required type [com.sun.javafx.collections.MappingChange$Map] for property 'maps': no matching editors or conversion strategy found
*/

	}
	
	
	@Test
	public void test03() {
		// TODO Auto-generated method stub
/*		Object bean = ioc.getBean("person01");
		System.out.println(bean);*/
		
		Person bean = (Person) ioc.getBean("person01");
		System.out.println(bean.getLastName() == null);
		System.out.println("person的car "+bean.getCar());
		Car bean2 = (Car) ioc.getBean("car01");
		bean2.setCarName("凯迪拉克");		
		
		System.out.println("我修改了容器car，你的car变了没？ "+bean.getCar());		
		Car car = bean.getCar();
//		Object bean2 = ioc.getBean("car01");
		System.out.println(bean2==car);

	}
	
	
	
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
	
	
//	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
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
