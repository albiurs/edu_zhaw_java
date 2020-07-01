package com.publicept.edu.java.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		
		while(a < 1000 && b < 1000) {
			a = a + b;
			System.out.println(a);
			b = b + a;
			System.out.println(b);
		}
	}

}
