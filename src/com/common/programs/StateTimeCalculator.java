package com.common.programs;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

public class StateTimeCalculator {

	// Represents a state event with start and end timestamps and state name
	static class StateEvent {
		LocalDateTime timeStamp;
		String state;

		public StateEvent(LocalDateTime timeStamp, String state) {
			this.timeStamp = timeStamp;
			this.state = state;
		}
	}

	// Calculates the total time spent in each state
	public static void calculateTimeInStates(List<StateEvent> stateEvents) {
		Map<String, Duration> stateDurations = new HashMap<>();

		for (int i = 0; i < stateEvents.size() - 1; i++) {
			StateEvent currentEvent = stateEvents.get(i);
			StateEvent nextEvent = stateEvents.get(i + 1);

			Duration duration = Duration.between(currentEvent.timeStamp, nextEvent.timeStamp);
			stateDurations.put(currentEvent.state, stateDurations.getOrDefault(currentEvent.state, Duration.ZERO).plus(duration));
		}
		// Handle the last state event separately
		StateEvent lastEvent = stateEvents.get(stateEvents.size() - 1);
		stateDurations.put(lastEvent.state, stateDurations.getOrDefault(lastEvent.state, Duration.ZERO).plus(Duration.between(lastEvent.timeStamp, now())));
		printDurations(stateDurations);
	}

	private static void printDurations(Map<String, Duration> stateDurations) {
		for (Map.Entry<String, Duration> sla : stateDurations.entrySet()) {
			System.out.println("State: " + sla.getKey() + " | time spent: " + sla.getValue().toHours());
		}
	}

	public static void main(String[] args) {
		// Sample state events (timestamps are in LocalDateTime format)
		List<StateEvent> stateEvents = new ArrayList<>();

		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 8, 0), "In progress"));
		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 10, 30), "Pause"));
		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 12, 45), "In progress"));
		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 14, 15), "Active"));
		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 16, 15), "Pause"));
		stateEvents.add(new StateEvent(LocalDateTime.of(2023, 8, 1, 17, 15), "Active"));

		// Calculate total time spent in each state
		calculateTimeInStates(stateEvents);
	}
}