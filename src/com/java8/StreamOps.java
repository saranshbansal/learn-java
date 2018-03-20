package com.java8;

public class StreamOps {

	public static void main(String[] args) {
		StreamOps op = new StreamOps();
		System.out.println(op.solution(new int[] { 0, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3 }));
	}

	int solution(int[] A) {
		int n = A.length;
		int[] L = new int[n + 1];
		L[0] = -1;
		for (int i = 0; i < n; i++) { // 7
			L[i + 1] = A[i];
		}
		int count = 0;
		int pos = (n + 1) / 2;
		System.out.println(pos);
		int candidate = L[pos];
		for (int i = 1; i <= n; i++) { // 1-8
			if (L[i] == candidate)
				count = count + 1;
		}
		System.out.println(count);
		if ((count > pos && n % 2 == 0) || (count > pos-1 && n % 2 != 0))
			return candidate;
		return (-1);
	}
}
