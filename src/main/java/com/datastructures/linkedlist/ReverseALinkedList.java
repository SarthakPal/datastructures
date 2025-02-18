package com.datastructures.linkedlist;

public class ReverseALinkedList {

    // Iterative Java program to reverse a linked list

    // Given the head of a list, reverse the list and return the head of reversed list
    static Node reverseList(Node head) {

        // Initialize three pointers: curr, prev and next
        Node curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {

            // Store next
            next = curr.next;

            // Reverse current node's next pointer
            curr.next = prev;

            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }

        // Return the head of reversed linked list
        return prev;
    }

    static Node reverseListUsingRecurrsion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseListUsingRecurrsion(head.next);

        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;

    }

    // This function prints the contents
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        head = reverseListUsingRecurrsion(head);

        System.out.print("\nReversed Linked List:");
        printList(head);

    }


}
