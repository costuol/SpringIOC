package com.atguigu.utils;

import java.lang.reflect.Method;



import java.util.Arrays;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;


public class LogUtils3 {


	public static void logStart(JoinPoint joinPoint) {
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("LogUtils3前置通知：【"+name+"】方法开始执行，用的参数列表【"+Arrays.asList(args)+"】");
	}

	public static void logReturn(JoinPoint joinPoint,Object result) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("LogUtils3返回通知：【"+name+"】方法执行完成，计算结果是：【"+result+"】");			
	}
	
	public static void logException(JoinPoint joinPoint,Exception exception) {
		
		System.out.println("LogUtils3异常通知：【"+joinPoint.getSignature().getName()+"】方法执行出现异常，异常信息是："+exception);			
	}

	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("LogUtils3后置通知：【"+joinPoint.getSignature().getName()+"】方法执行结束");			
	}
		
	
	
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		//args[0] = 100;
		Object proceed = null;
		try {

			System.out.println("【环绕前置通知】【"+name+"方法开始】");

			proceed = pjp.proceed(args);

			System.out.println("【环绕返回通知】【"+name+"方法返回，返回值"+proceed+"】");
		} catch (Exception e) {

			System.out.println("【环绕异常通知】【"+name+"】方法出现异常，异常信息："+e);

			throw new RuntimeException(e);
		} finally{

			System.out.println("【环绕后置通知】【"+name+"】方法结束");
		}
		
		return proceed;
	}

}
