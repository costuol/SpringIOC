package com.atguigu.utils;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.atguigu.impl.MyMathCalculator;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 * @author costuol
 *
 */
@Aspect//告诉Spring这是一个切面类
@Component
public class LogUtils {
	
	/**
	 * 告诉Spring每个方法都什么时候运行；
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
	 * 5个通知注解
	 * @Before：在目标方法之前运行；前置通知
	 * @After：在目标方法运行结束之后；后置通知
	 * @AfterReturning：在目标方法正常返回之后；返回通知
	 * @AfterThrowing：在目标方法抛出异常之后；异常通知
	 * @Around：环绕；环绕通知
	 */
	
	//想在目标方法执行之前运行:写切入点表达式
	//execution(访问权限符 返回值类型 方法签名)
	
	
	
	/**
	 * 切入点表达式的写法：
	 * 固定格式：execution(访问权限符 返回值类型 方法全类名（参数表）)
	 * 
	 * 通配符：
	 * 		*：
	 * 		1）匹配一个或者多个字符：execution(public int com.atguigu.impl.MyMath*.*(int, int))
	 * 		2）匹配任意一个参数：第一个是int类型，第二个参数是任意类型；（匹配两个参数）
	 * 			execution(public int com.atguigu.impl.MyMathCalculator.*(int, *))
	 * 		3）只能匹配一层路径
	 * 		4）权限位置*不能；权限位置不写就行。execution(int com.*(..)) 
	 * 		..:
	 * 		1）匹配任意多个参数，任意类型参数
	 * 		2）匹配任意多层路径
	 * 			execution(public int com.atguigu..MyMathCalculator.*(..))
	 * 
	 * 记住两种：
	 * 最精确的：execution(public int com.atguigu.impl.MyMathCalculator.add(int, int))
	 * 最模糊的：execution(* *(..))    execution(* *.*(..))：千万别写；
	 * 
	 * 
	 * 也可以加上“&&、||、！”
	 * execution(public int com.atguigu.impl.MyMath*.*(..))&&execution(* *.*(int,int))
	 * 
	 * 
	 */
	@Before("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logStart() {
		System.out.println("【xxx】方法开始执行，用的参数列表【xxx】");
	}
	
	//想在目标方法正常执行完成之后运行
	@AfterReturning("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logReturn() {
		System.out.println("【xxx】方法执行完成，计算结果是：【xxx】");			
	}
	
	//想在目标方法出现异常的时候运行
	@AfterThrowing("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logException() {
		System.out.println("【xxx】方法执行出现异常，异常信息是：xxx");			
	}

	//想在目标方法执行结束的时候运行
	@After("execution(public int com.atguigu.impl.MyMathCalculator.*(int, int))")
	public static void logEnd() {
		System.out.println("【xxx】方法执行结束");			
	}
}
