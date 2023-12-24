package com.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class AllCombinationsOfString {
	public Set<String> combinations = new HashSet<>();

	int count = 0;


	public static void main(String[] args) {
		AllCombinationsOfString instance = new AllCombinationsOfString();

		// Find all possible combinations of alphabets in the given string of size 4
		instance.possibleCombinations(4, "abcd", "", false); // set to true to allowed repetition
		instance.printAll();

		System.out.println("Total combinations: " + instance.count());
	}


	private int count() {
		return this.count;
	}


	private void printAll() {
		for (String combination : combinations) {
			System.out.println(combination);
		}
	}


	private boolean checkForUniqueCharacters(String string) {
		Set<Character> testUnique = new HashSet<>();
		for (char ch : string.toCharArray())
			testUnique.add(ch);
		return testUnique.size() == string.length();
	}


	public void possibleCombinations(int maxLength, String ogString, String currentString, boolean isRepetitionAllowed) {

		// If the current string has reached it's maximum length
		if (currentString.length() == maxLength) {
			// If the character repetition is allowed
			if (isRepetitionAllowed) {
				count++;
				combinations.add(currentString);
			}
			// If the character repetition is NOT allowed
			else {
				if (checkForUniqueCharacters(currentString)) {
					count++;
					combinations.add(currentString);
				}
			}
		}
		// Else add each letter from the alphabet to new strings and process these new strings again
		else {
			for (char c : ogString.toCharArray()) {
				String tempString = currentString;
				currentString += c;
				possibleCombinations(maxLength, ogString, currentString, isRepetitionAllowed);
				currentString = tempString;
			}
		}
	}
}
