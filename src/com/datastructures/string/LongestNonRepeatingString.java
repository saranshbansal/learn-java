package com.datastructures.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * The code implements the lengthOfLongestSubstring() method, which takes a string s as input and returns the length of
 * the longest substring without repeating characters.
 *
 * The code uses a HashSet to store the characters in the input string. It iterates through the characters from left to right,
 * and adds each character to the set if it does not already exist. If the character already exists in the set, it removes
 * it and shifts the left pointer by one. This process is repeated until all characters have been processed.
 *
 * The maximum length of the non-repeating substring is then calculated by comparing the right pointer with the left pointer.
 */
public class LongestNonRepeatingString {
	public static void main(String[] args) {
		LongestNonRepeatingString l = new LongestNonRepeatingString();
		System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			while(!set.add(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
