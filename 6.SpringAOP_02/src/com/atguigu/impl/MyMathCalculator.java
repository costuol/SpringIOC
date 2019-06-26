package com.atguigu.impl;

import org.springframework.stereotype.Service;

import com.atguigu.inter.Calculator;

import com.atguigu.utils.LogUtils;


@Service
public class MyMathCalculator implements Calculator{

	@Override
	public int add(int i, int j) {
		int  result = i + j;
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
