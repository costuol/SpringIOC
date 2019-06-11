package com.atguigu.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Person {
	
	//基本类型直接使用
	//<property name="lastName" value="张三"></property>自动进行类型转换
	private String lastName = "小明";
	private Integer age;
	private String gender;
	private String email;
	
	private Car car;
	
	private List<Book> books;
	
	private Map<String, Object> maps;
	
	private Properties properties;
	//xxxxxx
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("person创建了……");
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getLastName() {
		return lastName;
	}
/*	public void setAstName(String lastName) {
		this.lastName = lastName;
	}//假如把setLastName改成setAstName，Bean中property lastname必须相应改成Astname
	 //这是因为set后面跟着的才是属性名
*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
		System.out.println("setLastName……"+lastName);
		//System.out.printf("setLastName……1%s\n",lastName);
		//System.out.printf("setLastName……2"+lastName+"\n");
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//函数重载
	public Person(String lastName, Integer age, String gender) {
		super();
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		System.out.println("三个参数的构造器……");
	}
	
	public Person(String lastName, String email, String gender) {
		super();
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		System.out.println("三个参数的构造器……");
	}
	
	public Person(String lastName, Integer age, String gender, String email) {
		super();
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		System.out.println("有参构造器……");
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", email=" + email + ", car="
				+ car + ", books=" + books + ", maps=" + maps + ", properties=" + properties + "]";
	}
	
}
