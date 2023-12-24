package com.miscellaneous;

import java.io.IOException;

public class BalanceBraces {

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
	static boolean braces(String value) {
		Stack st = new Stack();
		for (char c : value.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				st.push(c);
			}

			if (c == ')' || c == '}' || c == ']') {
				if (st.isEmpty()) {
					return false;
				} else if (!isMatching(st.pop(), c)) {
					return false;
				}
			}
		}

		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {

		String input = "{}{}([]0)";

		System.out.println(braces(input));
	}

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

}
