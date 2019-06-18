package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.atguigu.impl.MyMathCalculator;
import com.atguigu.inter.Calculator;
import com.atguigu.proxy.CalculatorProxy;


public class AOPTest {

	/**
	 * 有了动态代理，日志记录可以做的非常强大；而且与业务逻辑解耦
	 * 
	 */
	@Test
	public void test() {
		Calculator calculator = new MyMathCalculator();
/*		calculator.add(1, 2);
		calculator.div(2, 1);
		calculator.mul(3, 4);
		calculator.sub(6, 2);*/
		
		System.out.println("=======================");
		
		//如果是拿到了这个对象的代理对象；代理对象执行加减乘除
		Calculator proxy = CalculatorProxy.getProxy(calculator);
		proxy.add(2, 1);
		proxy.mul(8, 1);
		proxy.sub(6, 3);
		proxy.div(4, 0);//错误测试
	}

}
