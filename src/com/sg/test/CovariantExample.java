package com.sg.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CovariantExample {
	public static void main(String...args) {
		List<Integer> iList = Arrays.asList(2,66,88,24,67);
		List<String> sList = Arrays.asList("Hello","World","Java","World");
		print(iList);
		print(sList);
		
		List<Integer> copyListInt = new ArrayList<Integer>();
		List<String> copyListStr = new ArrayList<String>();
		
		copy(copyListInt,iList);
		copy(copyListStr,sList);
		
		print(copyListInt);
		print(copyListStr);
		
	}
	//Producer extends Consumer super
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for (T o:src) {
			dest.add(o);
		}
	}
	
	public static void print(List<?> obj) {
		for (Object o : obj) {
			System.out.println(o);
		}
	}
}
