package com.sg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(44);
		list.add(55);
		
		List<Integer> other = new CopyOnWriteArrayList<Integer>();
				
				/*Collections.synchronizedList(list);
		
		Thread t1 = new Thread(() -> {
			other.add(88);
			other.add(33);
		});
		
		Thread t2 = new Thread(() -> {
			other.add(28);
			other.add(133);
		});
		
		t1.start();
		t2.start();
		
		System.out.println(other);
		*/
		/*
		 * Iterator<Integer> iter = list.iterator(); while(iter.hasNext()) {
		 * list.add(0,4); System.out.println(iter.next()); }
		 */

	}

}
