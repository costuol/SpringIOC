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

public class ValidateAspect {
	

	public static void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("ValidateAspect前置通知：【"+name+"】方法开始执行，用的参数列表【"+Arrays.asList(args)+"】");
	}
	
	public static void logReturn(JoinPoint joinPoint,Object result) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("ValidateAspect返回通知：【"+name+"】方法执行完成，计算结果是：【"+result+"】");			
	}
	
	public static void logException(JoinPoint joinPoint,Exception exception) {		
		System.out.println("ValidateAspect异常通知：【"+joinPoint.getSignature().getName()+"】方法执行出现异常，异常信息是："+exception);			
	}
	
	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("ValidateAspect后置通知：【"+joinPoint.getSignature().getName()+"】方法执行结束");	
	}
	
}
