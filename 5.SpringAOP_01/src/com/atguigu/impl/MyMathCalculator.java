package com.atguigu.impl;

import com.atguigu.inter.Calculator;

import com.atguigu.utils.LogUtils;

public class MyMathCalculator implements Calculator{

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
//		直接编写在方法内部；不推荐，修改维护麻烦
//		System.out.println("【add】方法开始了，它使用的参数是【"+i+","+j+"】");
		
//		方法的兼容性问题~
//		一样是直接写在方法内部；不推荐	
//		LogUtils.logStart(i,j);
		int  result = i + j;
//		System.out.println("【add】方法运行完成，计算结果是:【"+result+"】");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i - j;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i * j;
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i / j;
		return result;
	}

}
