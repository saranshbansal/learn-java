package com.common.programs;

import java.util.HashSet;

// Java program to remove duplicates from unsorted  
// linked list 
public class DistinctLinkedList
{

    static Node head;

    static class Node
    {

        int data;
        Node next;


        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    /* Function to remove duplicates from an 
       unsorted linked list */
    static void removeDuplicate(Node head)
    {
        // Hash to store seen values 
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null)
        {
            int curval = current.data;

            // If current value is seen before 
            if (hs.contains(curval))
            {
                prev.next = current.next;
            }
            else
            {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }


    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args)
    {
        DistinctLinkedList list = new DistinctLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates : \n ");
        list.printList(head);

        DistinctLinkedList.removeDuplicate(head);
        System.out.println("");
        System.out.println("Linked List after removing duplicates : \n ");
        list.printList(head);
    }

}
// This code has been contributed by Mayank Jaiswal 
