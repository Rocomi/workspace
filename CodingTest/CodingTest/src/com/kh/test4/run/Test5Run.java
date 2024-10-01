package com.kh.test4.run;

public class Test5Run {

	public static void main(String[] args) {
		
		int n = 20;
		int m = 50;
		String ineq = "<";
		String eq = "=";
		
		System.out.println(eq.equals("=") ? ineq.equals("<") ?  n <= m : n >= m   : ineq.equals("<") ?  n < m : n > m);

	}

}
