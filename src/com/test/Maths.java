package com.test;

public class Maths {
public static void main(String[] args) {
	long monthsBetween = 1;
	if(monthsBetween % 3 != 0) {
		int diff = (int) ((Math.ceil(monthsBetween / 3) + 1) * 3);
		System.out.println(diff);
	}
}
}
