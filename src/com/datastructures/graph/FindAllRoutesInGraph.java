package com.datastructures.graph;

import java.util.LinkedList;

/**
 * @author sbansal
 * <p>
 * It appears that this can be accomplished with a depth-first search of
 * the graph. The depth-first search will find all non-cyclical paths
 * between two nodes. This algorithm should be very fast and scale to
 * large graphs (The graph data structure is sparse so it only uses as
 * much memory as it needs to).
 * <p>
 * I noticed that the graph you specified above has only one edge that
 * is directional (B,E). Was this a typo or is it really a directed
 * graph? This solution works regardless. Sorry I was unable to do it in
 * C, I'm a bit weak in that area. I expect that you will be able to
 * translate this Java code without too much trouble though.
 */
public class FindAllRoutesInGraph {
	private static final String START = "B";
	private static final String END = "E";


	public static void main(String[] args) {
		// this graph is directional
		Graph graph = new Graph();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "A");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E"); // this is the only one-way connection
		graph.addEdge("B", "F");
		graph.addEdge("C", "A");
		graph.addEdge("C", "E");
		graph.addEdge("C", "F");
		graph.addEdge("D", "B");
		graph.addEdge("E", "C");
		graph.addEdge("E", "F");
		graph.addEdge("F", "B");
		graph.addEdge("F", "C");
		graph.addEdge("F", "E");
		LinkedList<String> visited = new LinkedList();
		visited.add(START);
		new FindAllRoutesInGraph().depthFirst(graph, visited);
	}


	private void depthFirst(Graph graph, LinkedList<String> visited) {
		LinkedList<String> nodes = graph.adjacentNodes(visited.getLast());
		// examine adjacent nodes
		for (String node : nodes) {
			if (visited.contains(node)) {
				continue;
			}
			if (node.equals(END)) {
				visited.add(node);
				printPath(visited);
				visited.removeLast();
				break;
			}
		}
		for (String node : nodes) {
			if (visited.contains(node) || node.equals(END)) {
				continue;
			}
			visited.addLast(node);
			depthFirst(graph, visited);
			visited.removeLast();
		}
	}


	private void printPath(LinkedList<String> visited) {
		for (String node : visited) {
			System.out.print(node);
			System.out.print(" ");
		}
		System.out.println();
	}
}
