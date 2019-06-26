package com.atguigu.impl;

import org.springframework.stereotype.Service;

import com.atguigu.inter.Calculator;

import com.atguigu.utils.LogUtils2;


@Service
public class MyMathCalculator3{

	
	public int add(int i, int j) {
		int  result = i + j;
		return result;
	}

	
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i - j;
		return result;
	}

	
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i * j;
		return result;
	}

	
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		int  result = i / j;
		return result;
	}

}
