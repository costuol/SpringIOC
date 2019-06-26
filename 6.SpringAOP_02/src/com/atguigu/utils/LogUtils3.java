package com.atguigu.utils;

import java.lang.reflect.Method;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.atguigu.impl.MyMathCalculator3;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态的在目标方法运行的各个位置切入
 * @author costuol
 *
 */
@Aspect//告诉Spring这是一个切面类
@Component
public class LogUtils3 {
	
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
	 * 
	 * 抽取可重用的切入点表达式；
	 * 1、随便声明一个没有实现的返回void的空方法
	 * 2、给方法上标注@Pointcut注解
	 */
	@Pointcut("execution(public int com.atguigu.impl.MyMathCalculator3.*(..))")
	public void hahaMyPoint() {};
	
	//想在目标方法执行之前运行:写切入点表达式
	//execution(访问权限符 返回值类型 方法签名)
	
	//@Before("hahaMyPoint()")
	public static void logStart(JoinPoint joinPoint) {
		//获取到目标方法运行时使用的参数
		Object[] args = joinPoint.getArgs();
		//获取到方法签名
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法开始执行，用的参数列表【"+Arrays.asList(args)+"】");
	}
	
	//想在目标方法正常执行完成之后运行
	//告诉Spring这个result用来接收返回值
	//returning = "result"
	
	//@AfterReturning(value="hahaMyPoint()",returning="result")
	public static void logReturn(JoinPoint joinPoint,Object result) {
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("【"+name+"】方法执行完成，计算结果是：【"+result+"】");			
	}
	
	
	/**
	 * 细节四：我们可以在通知方法运行的时候，拿到方法的详细信息
	 * 1）只需要为通知方法的参数列表上写一个参数：
	 * 		Joinpoint joinpPoint：封装了当前目标方法的详细信息
	 * 2）告诉Spring哪个参数是用来接收异常
	 * 		throwing="exception"：告诉Spring哪个参数是用来接收异常
	 * 3）Exception exception：指定通知方法可以接收哪些异常
	 * 
	 */
	//想在目标方法出现异常的时候运行
	//@AfterThrowing(value="hahaMyPoint()",throwing="exception")
	public static void logException(JoinPoint joinPoint,Exception exception) {
		
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行出现异常，异常信息是："+exception);			
	}

	//想在目标方法执行结束的时候运行
	
	/**
	 * Spring对通知方法的要求不严格
	 * 唯一要求的就是方法的参数列表一定不能乱写，为什么？
	 * 	通知方法是Spring利用反射调用的，每次方法调用得确定这个方法的参数表的值；
	 * 	参数表上每一个参数，Spring都得知道是什么
	 * 	JoinPoint：认识
	 * 	不知道的参数一定要告诉Spring这个是什么
	 * @param joinPoint
	 */
	//@After("hahaMyPoint()")
	public static void logEnd(JoinPoint joinPoint) {
		System.out.println("【"+joinPoint.getSignature().getName()+"】方法执行结束");			
	}
	
	
	/**
	 * @throws Throwable 
	 * @Around：环绕	:是Spring中强大的通知；
	 * @Around：环绕:动态代理；
	 * 	try{
	 * 			//前置通知
	 * 			method.invoke(obj,args);
	 * 			//返回通知
	 * 	}catch(e){
	 * 			//异常通知
	 *  }finally{
	 * 			//后置通知
	 * 	}
	 * 		
	 * 	四合一通知就是环绕通知；
	 * 	环绕通知中有一个参数：	ProceedingJoinPoint pjp
	 * 
	 *环绕通知：是优先于普通通知执行，执行顺序；
	 *
	 *[普通前置]
	 *{
	 *	try{
	 *		环绕前置
	 *		环绕执行：目标方法执行
	 *		环绕返回
	 *	}catch(){
	 *		环绕出现异常
	 *	}finally{
	 *		环绕后置
	 *	}
	 *}
	 *
	 *
	 *[普通后置]
	 *[普通方法返回/方法异常]
	 *新的顺序：
	 *		（环绕前置---普通前置）----目标方法执行----环绕正常返回/出现异常-----环绕后置----普通后置---普通返回或者异常
	 *注意：
	 */
	
	@Around("hahaMyPoint()")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		
		Object[] args = pjp.getArgs();
		String name = pjp.getSignature().getName();
		//args[0] = 100;
		Object proceed = null;
		try {
			//@Before
			System.out.println("【环绕前置通知】【"+name+"方法开始】");
			//就是利用反射调用目标方法即可，就是method.invoke(obj,args)
			proceed = pjp.proceed(args);
			//@AfterReturing
			System.out.println("【环绕返回通知】【"+name+"方法返回，返回值"+proceed+"】");
		} catch (Exception e) {
			//@AfterThrowing
			System.out.println("【环绕异常通知】【"+name+"】方法出现异常，异常信息："+e);
			//为了让外界能知道这个异常，这个异常一定抛出去
			throw new RuntimeException(e);
		} finally{
			//@After
			System.out.println("【环绕后置通知】【"+name+"】方法结束");
		}
		
		//反射调用后的返回值也一定返回出去
		return proceed;
	}

}
