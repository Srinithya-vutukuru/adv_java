package com.sg;

import java.util.concurrent.Callable;

public class Sumer implements Callable<Integer> {
	
	private int start;
	private int end;
	
	public Sumer(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i =start;i<=end;i++) {
			sum  += i;
			System.out.println(Thread.currentThread() + " : "+ i);
		}
		return sum;
	}

}

//public class Sumer implements Runnable<Integer> {
//	
//	private int start;
//	private int end;
//	
//	public Sumer(int start, int end, Object placeholder) {
//		this.start = start;
//		this.end = end;
//	}
//
//	@Override
//	public Integer call() throws Exception {
//		int sum = 0;
//		for (int i =start;i<=end;i++) {
//			sum  += i;
//		}
//		return sum;
//	}
//
//}
