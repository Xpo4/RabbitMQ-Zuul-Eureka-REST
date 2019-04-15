package com.example.demo.reposytory;


import java.util.HashSet;
import java.util.Set;

public class test {

	public static void main(String[] args) {
		Set<A> s = new HashSet<A>();
		A a = new A();
		a.id = 5;
		s.add(a);
		a.id = 8;
		//s.forEach(ss -> System.out.println(ss.id));
		A b = new A();
		b.id = 8;
		System.out.println(s.remove(b));
		 
	}

}
