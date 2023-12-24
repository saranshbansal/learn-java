package com.miscellaneous;

import java.util.Arrays;

public class StringPermutationCheck {
	public static void main(String[] args) {
		StringPermutationCheck obj = new StringPermutationCheck();
		System.out.println(obj.checkPermutation("abcd", "bacd"));
	}


	private boolean checkPermutation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		char[] ar1 = str1.toCharArray();
		Arrays.sort(ar1);

		char[] ar2 = str2.toCharArray();
		Arrays.sort(ar2);

		return isMismatched(ar1, ar2);
	}


	private boolean isMismatched(char[] ar1, char[] ar2) {
		for (int i = 0; i < ar2.length; i++) {
			if (ar1[i] != ar2[i])
				return false;
		}
		return true;
	}
}
