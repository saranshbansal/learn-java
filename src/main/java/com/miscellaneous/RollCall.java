package com.miscellaneous;

import java.util.Arrays;

public class RollCall {

	public static void print(int studentsCount, int[] rollCallList) {
		if (rollCallList.length > studentsCount)
			return;

		String[] output = new String[rollCallList.length];

		try {
			String[] sortedRollCalls = new String[studentsCount];

			for (int i = 0; i < studentsCount; i++) {
				sortedRollCalls[i] = (i + 1) + "";
			}

			Arrays.sort(sortedRollCalls);

			for (int j = 0; j < rollCallList.length; j++) {
				output[j] = sortedRollCalls[rollCallList[j] - 1];
			}

			System.out.println("ans = " + Arrays.toString(output));
		} catch (Exception e) {
			return;
		}
	}


	public static void main(String[] args) {
		RollCall.print(12, new int[]{2, 5});
	}
}
