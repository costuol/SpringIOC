package com.atguigu.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)//使用order改变切面执行顺序
public class ValidateAspect {
	
	@Before("com.atguigu.utils.LogUtils3.hahaMyPoint()")
	public static void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法开始执行，用的参数列表【"+Arrays.asList(args)+"】");
	}
	
	@AfterReturning(value="com.atguigu.utils.LogUtils3.hahaMyPoint()",returning="result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法执行完成，计算结果是：【"+result+"】");			
	}
	
	@AfterThrowing(value="com.atguigu.utils.LogUtils3.hahaMyPoint()",throwing="exception")
	public static void logException(JoinPoint joinPoint,Exception exception) {		
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行出现异常，异常信息是："+exception);			
	}
	
	@After("com.atguigu.utils.LogUtils3.hahaMyPoint()")
	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行结束");	
	}
	
}
