package com.miscellaneous;

// Algorithm Paradigm: Backtracking
// Time Complexity: O(n*n!)
public class AllCombinationsOfStringEfficientApproach {
	int count;


	public static void main(String[] args) {
		AllCombinationsOfStringEfficientApproach instance = new AllCombinationsOfStringEfficientApproach();

		String str = "abcd";
		instance.possibleCombinations(str, 0, str.length() - 1);
		System.out.println("Total combinations: " + instance.getCount());
	}


	private int getCount() {
		return this.count;
	}


	public void possibleCombinations(String str, int l, int r) {
		if (l == r) {
			count++;
			System.out.println(str);
		} else {
			for (int i = 1; i <= r; i++) {
				str = swap(str, l, i);
				possibleCombinations(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}


	private String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
