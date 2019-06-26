package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.impl.MyMathCalculator;
import com.atguigu.impl.MyMathCalculator2;
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
		System.out.println("————————————");
		Bean.add(2, 4);
		System.out.println("————————————");
		Bean.div(4, 0);
	}
	
	/**
	 * 通知方法的执行顺序；
	 * 
	 * try{
	 * 		@Before
	 * 		method.invoke(obj.args)
	 * 		@AfterReturning
	 * }catch(e){
	 * 		@AfterThrowing
	 * }finally{
	 * 		@After
	 * }
	 * 
	 * 正常执行：@Before（前置通知）——>@After（后置通知）——>@AfterReturning（正常返回）；
	 * 异常执行：@Before（前置通知）——>@After（后置通知）——>@AfterReturning（异常返回）；
	 * 
	 * 
	 */
	@Test
	public void test3() {
		MyMathCalculator2 Bean = ioc.getBean(MyMathCalculator2.class);
		Bean.div(4, 2);
		System.out.println("————————————");
		Bean.add(2, 4);
		System.out.println("————————————");
		Bean.div(4, 0);
	}
	
	@Test
	//没有接口就是本类类型
	//com.atguigu.impl.MyMathCalculator$$EnhancerByCGLIB$$f15495f9
	//cglib帮我们创建好的代理对象；
	public void test2() {
		MyMathCalculator2 Bean = ioc.getBean(MyMathCalculator2.class);
		Bean.add(2, 3);
		System.out.println(Bean.getClass());
	}
	
	
	@Test
	public void test() {
//		MyMathCalculator myMathCalculator = new MyMathCalculator();
//		myMathCalculator.add(2, 12);
		//1、从ioc容器中拿到目标对象；注意：如果想要用类型，一定用他的接口类型，不要用他本类
		//细节一：com.atguigu.impl.MyMathCalculator@1c7696c6
		//class com.sun.proxy.$Proxy13
		
		
		//AOP的底层就是动态代理，容器中保存的组件就是他的代理对象；$Proxy13。当然不是本类的类型
		Calculator bean = ioc.getBean(Calculator.class);
		bean.add(1, 2);
		System.out.println(bean);
		System.out.println(bean.getClass());
		
		Calculator bean2 = (Calculator) ioc.getBean("myMathCalculator");
		System.out.println(bean2.getClass());
	}

}
