package com.datastructures.graph;

import java.util.*;

public class Graph {
	private Map<String, LinkedHashSet<String>> map = new HashMap();


	public void addEdge(String node1, String node2) {
		LinkedHashSet<String> adjacent = map.get(node1);
		if (adjacent == null) {
			adjacent = new LinkedHashSet();
			map.put(node1, adjacent);
		}
		adjacent.add(node2);
	}


	public void addTwoWayVertex(String node1, String node2) {
		addEdge(node1, node2);
		addEdge(node2, node1);
	}


	public boolean isConnected(String node1, String node2) {
		Set adjacent = map.get(node1);
		if (adjacent == null) {
			return false;
		}
		return adjacent.contains(node2);
	}


	public LinkedList<String> adjacentNodes(String last) {
		LinkedHashSet<String> adjacent = map.get(last);
		if (adjacent == null) {
			return new LinkedList();
		}
		return new LinkedList<>(adjacent);
	}
}
