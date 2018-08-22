package com.test;

import java.io.IOException;
import java.util.Arrays;

public class BalanceBraces {

	static class Stack {
		int top = -1;
		char items[] = new char[100];

		void push(char c) {
			if (top == 99) {
				// Stack full
			} else {
				items[++top] = c;
			}
		}

		char pop() {
			if (top == -1) {
				return '0';
			} else {
				char e = items[top];
				top--;
				return e;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	static boolean isMatching(char c1, char c2) {
		if (c1 == '(' && c2 == ')') {
			return true;
		} else if (c1 == '{' && c2 == '}') {
			return true;
		} else if (c1 == '[' && c2 == ']') {
			return true;
		} else {
			return false;
		}
	}

	// Complete the braces function below.
	static String[] braces(String[] values) {
		String[] result = new String[values.length];
		Stack st = new Stack();
		int index = 0;
		for (String value : values) {
			for (int i = 0; i < value.length(); i++) {
				if (value.charAt(i) == '(' || value.charAt(i) == '{' || value.charAt(i) == '[') {
					st.push(value.charAt(i));
				}

				if (value.charAt(i) == ')' || value.charAt(i) == '}' || value.charAt(i) == ']') {
					if (st.isEmpty()) {
						result[index] = "NO";
					} else if (!isMatching(st.pop(), value.charAt(i))) {
						result[index] = "NO";
					}
				}
			}

			if (st.isEmpty()) {
				result[index] = "YES";
			} else {
				result[index] = "NO";
			}
			index++;

		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		int valuesCount = 10;

		String[] values = new String[valuesCount];

		for (int i = 0; i < valuesCount; i++) {
			values[i] = "{}{}()"; // manipulate
		}

		String[] res = braces(values);
		Arrays.stream(res).forEach(obj -> System.out.println(obj));
	}

}
