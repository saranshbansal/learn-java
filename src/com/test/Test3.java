package com.test;

public class Test3 {

	static class Node {
		Node next;
		int key;

		public Node(int key) {
			super();
			this.key = key;
		}

	}

	public static void main(String[] args) {

		Node node = new Node(101);
		node.next = new Node(201);
		node.next.next = new Node(301);
		node.next.next.next = new Node(401);
		System.out.println(countNodesinLoop(node));
	}

	/*
	 * This function detects and counts loop nodes in the list. If loop is not there
	 * in then returns 0
	 */
	private static int countNodesinLoop(Node list) {
		if(list == null) {			
			return 0;
		}
		return 1 + countNodesinLoop(list.next);
	}

}
