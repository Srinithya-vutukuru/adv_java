package com.sg;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PoolExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<Integer> f1 = service.submit(new Sumer(1,999));
		Future<Integer> f2 = service.submit(new Sumer(783,999));
		Future<Integer> f3 = service.submit(new Sumer(100,999));
		Future<Integer> f4 = service.submit(new Sumer(10,999));
		
		try {
			System.out.println(f1.get(1/*(long) 0.1*/,TimeUnit.NANOSECONDS));
			System.out.println(f2.get());
			System.out.println(f3.get());
			System.out.println(f4.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		service.shutdown();// no longer accepts tasks and execute all the existing jobs
	}

}
