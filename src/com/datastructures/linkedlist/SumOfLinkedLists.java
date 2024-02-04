package com.datastructures.linkedlist;

import com.datastructures.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class SumOfLinkedLists {
	public static void main(String[] args) {
		SumOfLinkedLists s = new SumOfLinkedLists();
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));
		ListNode l3 = s.addTwoNumbers(l1, l2);

		System.out.println(l3);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;

		int carry = 0;

		while (l1 != null || l2 != null || carry > 0) {
			int sum = carry;

			if (l1 != null) {
				sum += l1.getVal();
				l1 = l1.getNext();
			}
			if (l2 != null) {
				sum += l2.getVal();
				l2 = l2.getNext();
			}
			carry = sum / 10;
			int unitDigit = sum % 10;
			tail.setNext(new ListNode(unitDigit));
			tail = tail.getNext();
		}

		ListNode result = dummyHead.getNext();
		dummyHead.setNext(null);
		return result.getNext();
	}
}
