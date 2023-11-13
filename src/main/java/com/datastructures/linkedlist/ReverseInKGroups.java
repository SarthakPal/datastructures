package com.datastructures.linkedlist;

// Recursive Java program to reverse
// a linked list

class ReverseInKGroups {
    static Node head; // head of list

    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    static Node reverse(Node head, int size)
    {
        if (head == null)
            return head;
        int k = size;
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null && k>0)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        if(curr==null && k>0)
        {
            curr = prev;
            prev = null;
            next = null;
            while(curr!=null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
        head.next = reverse(curr,size);
        return prev;
    }

    /* Function to print linked list */
    static void print()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void push(int data)
    {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    /* Driver program to test above function*/
    public static void main(String args[])
    {
        /* Start with the empty list */
        push(80);
        push(70);
        push(60);
        push(50);
        push(40);
        push(30);
        push(20);
        push(10);

        System.out.println("Given linked list");
        print();

        head = reverse(head, 3);

        System.out.println("Reversed linked list");
        print();
    }
}

// This code is contributed by Prakhar Agarwal


