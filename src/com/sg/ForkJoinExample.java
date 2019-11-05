package com.sg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 1000; i++) {
			list.add((int) (Math.random() * 1000));
		}
		int result = pool.invoke(new RecursiveSum(list,0,list.size()-1));
		System.out.println(result);
	}

}
