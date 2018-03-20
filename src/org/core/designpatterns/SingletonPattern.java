package org.core.designpatterns;

public class SingletonPattern {

	private static volatile SingletonPattern instance;

	private SingletonPattern() {
	}

	public static SingletonPattern getInstance() {
		if (instance == null) {
			synchronized (SingletonPattern.class) {
				if (instance == null) {
					instance = new SingletonPattern();
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		System.out.println(SingletonPattern.getInstance());
	}
}
