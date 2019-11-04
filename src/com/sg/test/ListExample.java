package com.sg.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sg.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
        products.add(new Product(645, "Hp Laptop", 135000.00, "computer"));
        products.add(new Product(224, "iPhone", 98000.00, "mobile"));
        products.add(new Product(834, "Logitech Mouse", 600.00, "computer"));
        products.add(new Product(5, "Sony Bravia", 125000.00, "tv"));
        products.add(new Product(912, "One Plus", 32000.00, "mobile"));
        products.add(new Product(88, "HP Printer", 19000.00, "computer"));
        
		/*
		 * Collections.sort(products , (o1,o2) -> Double.compare(o1.getPrice(),
		 * o2.getPrice()));
		 * 
		 * for(Product p : products) { System.out.println(p); }
		 */
        // @formatter:off
        products.stream()
        	.filter(p -> p.getCategory().equals("computer"))
        	.forEach(c -> System.out.println(c));
        
        
        products.stream()
        	.map(p -> p.getName())
        	.forEach(System.out::println);
        
        double sum = products.stream()
    	.map(p -> p.getPrice())
    	.reduce(0.0, (acc,val) -> (acc>val ? acc : val));
        
        System.out.println(sum);
        
        
        Map<String, List<Product>> map = products.stream()
        											.collect(Collectors.groupingBy(p -> p.getCategory()));
        
        map.forEach((k,v) -> {
        	System.out.println(k);
        	v.forEach(System.out::println);
        	System.out.println("*********");
        });
        
        DoubleSummaryStatistics stats = products.stream()
        									.collect(Collectors.summarizingDouble(p -> p.getPrice()));
        
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getMin());
        // @formatter:on
	}

}
