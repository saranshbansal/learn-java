package com.miscellaneous;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	// store keys in cache
	static Deque<Integer> queue;
	// store references of key in cache
	static HashSet<Integer> keyRefMap;
	// maximum capacity of cache
	static int cacheSize;


	LRUCache(int n) {
		queue = new LinkedList<>();
		keyRefMap = new HashSet<>();
		cacheSize = n;
	}

	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4);
		ca.refer(1);
		ca.refer(2);
		ca.refer(3);
		ca.refer(1);
		ca.refer(4);
		ca.refer(5);
		ca.display();
	}

	/* Refers key x with in the LRU cache */
	public void refer(int x) {
		if (!keyRefMap.contains(x)) {
			if (queue.size() == cacheSize) {
				int last = queue.removeLast();
				keyRefMap.remove(last);
			}
		} else {
            /* The found page may not be always the last element, even if it's an
               intermediate element that needs to be removed and added to the start
               of the Queue */
			int index = 0, i = 0;
			Iterator<Integer> itr = queue.iterator();
			while (itr.hasNext()) {
				if (itr.next() == x) {
					index = i;
					break;
				}
				i++;
			}
			queue.remove(index);
		}
		queue.push(x);
		keyRefMap.add(x);
	}

	// display contents of cache
	public void display() {
		Iterator<Integer> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}
}
