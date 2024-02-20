package com.datastructures.linkedlist;

public class AddTwoNumbers {

    public static class Node {
      int val;
      Node next;
      Node() {}
      Node(int val) { this.val = val; }
      Node(int val, Node next) { this.val = val; this.next = next; }

    }

    static Node res = null;

    public static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr!=null)
        {
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void addInResultList(int val)
    {
        if(res == null)
        {
            res = new Node(val);
        }
        else {
            Node temp = new Node(val);
            temp.next = res;
            res = temp;
        }
    }

    public static Node solve(Node a, Node b)
    {

        int carry = 0;

        a = reverse(a);
        b = reverse(b);

        while(a!=null && b!=null)
        {
            int first = a.val;
            int second = b.val;
            int sum = first + second + carry;
            if(sum<10)
            {
                addInResultList(sum);
                carry = 0;
            }
            else
            {
                addInResultList(sum%10);
                carry = 1;
            }
            a = a.next;
            b = b.next;
        }

        while(a!=null)
        {
            int num = a.val;
            int sum = num + carry;
            if(sum<10)
            {
                addInResultList(sum);
                carry = 0;
            }
            else
            {
                addInResultList(sum%10);
                carry = 1;
            }
            a = a.next;
        }

        while(b!=null)
        {
            int num = b.val;
            int sum = num + carry;
            if(sum<10)
            {
                addInResultList(sum);
                carry = 0;
            }
            else
            {
                addInResultList(sum%10);
                carry = 1;
            }
            b = b.next;
        }

        if(carry!=0)
        {
            addInResultList(carry);
        }

        return res;

    }

    public static void print(Node head)
    {
        while(head!=null)
        {
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static void main(String[] args)
    {

        Node head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        Node head2 = new Node(8);
        head2.next = new Node(4);

        System.out.print("Sum List : ");
        // add the two lists and see the result
        print(solve(head1, head2));
    }

}
