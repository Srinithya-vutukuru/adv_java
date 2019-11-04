package com.sg.client;

import java.util.function.Function;

public class FunctionalExample {

	public static void main(String[] args) {
		Function<Integer, Double> f1 = new Function<Integer, Double>(){

			@Override
			public Double apply(Integer t) {
				return t / 2.0;
			}
			
		};
		
		System.out.println(f1.apply(5));
		
		//Java 8 Lambda
		
		Function<Integer, Double> f2 = (Integer t) -> {
			return t / 2.0;
		};
		
		Function <Integer, Double> f3 = (t) -> t/3.0;
		
		System.out.println(f3.apply(4));
	}

}
