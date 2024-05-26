package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i < 5; i++)
			list.add(i);
		
		Stream s = list.stream();
		s.collect(Collectors.toList());
		s.forEach( ss-> System.out.println(ss));
	}
}
