package com.atguigu.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 1）编写后置处理器的实现类
 * 2）将后置处理器注册在配置文件中
 * @author costuol
 *
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	/** 
	 * postProcessBeforeInitialization:
	 * 		初始化方法之前调用
	 * 		Object bean将要初始化的bean
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("【"+beanName+"】bean将要调用初始化方法了……这个bean是这个样：【"+bean+"】");
		//返回传入的bean
		return bean;
	}

	/** 
	 * postProcessAfterInitialization:
	 * 		初始化方法之后调用	 
	 * Object bean,
	 * String beanName：bean在xml中配置的id
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("【"+beanName+"】bean初始化方法调用完了……AfterInitialization");
		return bean;
	}

}
