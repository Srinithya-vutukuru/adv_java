package com.sg.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sg.entity.Article;

public class ArticleClient {
	public static void main(String... args) {
		List<Article> articles = new ArrayList<>();
        articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
        articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
        articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
        articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
        articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
        
        //get a total word count for all the articles in the list
        printTotalWordCount(articles); // 5219
        printTags(articles);
        printArticlesByType(articles); //{bliki:4, article: 1}
	}

	private static void printArticlesByType(List<Article> articles) {
		Map<String, Long> map = articles.stream()
			.collect(Collectors.groupingBy(a->a.getType(), Collectors.counting()));
		System.out.println(map);
	}

	private static void printTags(List<Article> articles) {
		articles.stream()
			.flatMap(p->p.getTags().stream())
			.distinct()
			.forEach(System.out::println);
		
	}

	private static void printTotalWordCount(List<Article> articles) {
		int sum = articles.stream()
			.map(p->p.getWords())
			.reduce(0,((acc,val) -> acc+val));
		System.out.println(sum);
	}

}
