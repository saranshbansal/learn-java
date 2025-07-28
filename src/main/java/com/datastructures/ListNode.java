package com.datastructures;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
	}
}
