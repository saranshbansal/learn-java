package com.datastructures.arrays;

import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * https://leetcode.com/problems/reward-top-k-students/
 */
public class TopKStudentsByFeedbacks {
	public static void main(String[] args) {
		String[] positiveFeedbacks = {"pyuknvau", "nc", "hwcpe", "wn"};
		String[] negativeFeedbacks = {"bjzzjcgxv", "dibldp", "pmlb"};
		String[] report = {"qws z pmlb xmcugvuos lpnygddx bjzzjcgxv hwcpe pmlb pmlb rocg", "hwcpe pyuknvau dibldp bjzzjcgxv bjzzjcgxv hwcpe wn pmlb pyuknvau wodnvd", "dibldp dibldp gna dibldp pmlb pyuknvau pyuknvau nc iygs rkhtnjreq", "pmlb aas wn hwcpe bjzzjcgxv otird pyuknvau fdl bjzzjcgxv dibldp"};
		int[] studentIds = {357574114, 899543310, 676388750, 793586311};
		int k = 2;
		TopKStudentsByFeedbacks topKStudentsByFeedbacks = new TopKStudentsByFeedbacks();
		List<Integer> result = topKStudentsByFeedbacks.topStudents(positiveFeedbacks, negativeFeedbacks, report, studentIds, k);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public List<Integer> topStudents(String[] positiveFeedbacks, String[] negativeFeedbacks, String[] report, int[] studentIds, int k) {
		Map<Integer, Integer> studentIdToScore = new HashMap<>();

		for (int i = 0; i < report.length; i++) {
			int score = 0;
			String[] words = report[i].split(" ");
			for (String word : words) {
				if (isFeedbackPresent(positiveFeedbacks, word)) {
					score += 3;
				} else if (isFeedbackPresent(negativeFeedbacks, word)) {
					score -= 1;
				}
			}
			studentIdToScore.putIfAbsent(studentIds[i], score);
		}

		// sort the map by value in descending order and then by key in ascending order.
		Map<Integer, Integer> sortedMap = studentIdToScore.entrySet().stream()
				.sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(k)
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return new ArrayList<>(sortedMap.keySet());
	}

	private boolean isFeedbackPresent(String[] feedbacks, String word) {
		return Arrays.asList(feedbacks).contains(word);
	}
}
