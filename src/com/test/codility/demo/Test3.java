package com.test.codility.demo;

import java.util.HashMap;
import java.util.Map;

class Test3 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{4,6,2,2,6,6,4}));
	}
    static int solution(int[] A) {
    	int N = A.length;
        Map<Integer, Integer> kvmap = new HashMap<Integer, Integer>( );
        Integer result = 0;
        for (int i = 0; i < N; i++) {
            if (!kvmap.containsKey(A[i])) {
                kvmap.put(A[i], i);
            } else {
                result = Math.max(result, i - kvmap.get(A[i]));
            }
        }
        return result;
    	
    	
        /*int N = A.length;
        int result = 0;
        for (int i = 0; i < N; i++)
            for (int j = i; j < N; j++)
                if (A[i] != A[j])
                    result = Math.max(result, j - i);*/
        // return result;
    }
}