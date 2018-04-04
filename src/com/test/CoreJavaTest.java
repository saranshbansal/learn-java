package com.test;

class Parent {
	String m1() {
		System.out.println("P");
		return null;
	}
}

class Child extends Parent {
	String m1() throws RuntimeException {
		System.out.println("C");
		return "";
	}

}

public class CoreJavaTest {
	public static void main(String[] args) {
		Parent p = new Child();
		Parent c = new Parent();
		p.m1();
		c.m1();
	}
}



