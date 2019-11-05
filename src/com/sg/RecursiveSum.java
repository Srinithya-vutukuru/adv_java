package com.sg;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class RecursiveSum extends RecursiveTask<Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> list;
	private int start;
	private int end;
	private static final int THRESHOLD = 10;
	
	public RecursiveSum(List<Integer> list, int start, int end) {
		this.list=list;
		this.start= start;
		this.end = end;
	}
	
	@Override
	protected Integer compute() {
		if((end - start) <= THRESHOLD) {
			int sum=0;
			for(int i = start; i <= end; i++) {
				sum+=list.get(i);
			}
			return sum;
		}
		else {
			int mid = (end + start) / 2;
			RecursiveSum left = new RecursiveSum(list,start,mid);
			RecursiveSum right = new RecursiveSum(list,mid+1,end);
			
			return left.fork().join() + right.compute();
		}
	}

}
