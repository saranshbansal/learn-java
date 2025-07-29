package com.datastructures.linkedlist;

import java.util.HashSet;

class Node {

    int data;
    Node next;


    Node(int d) {
        data = d;
        next = null;
    }
}


// Java program to remove duplicates from unsorted  
// linked list 
public class RemoveDuplicatesLinkedList {

    /* Function to remove duplicates from an
       unsorted linked list */
    static void removeDuplicate(Node head) {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node start = head;
        Node prev = null;
        while (start != null) {
            int data = start.data;

            // If current value is seen before
            if (hs.contains(data)) {
                prev.next = start.next;
            } else {
                hs.add(data);
                prev = start;
            }
            start = start.next;
        }

    }


    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(12);
        head.next.next = new Node(11);
        head.next.next.next = new Node(11);
        head.next.next.next.next = new Node(12);
        head.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates :");
        RemoveDuplicatesLinkedList.printList(head);

        System.out.println("\n");

        System.out.println("Linked List after removing duplicates :");
        RemoveDuplicatesLinkedList.removeDuplicate(head);
        RemoveDuplicatesLinkedList.printList(head);
    }

}
