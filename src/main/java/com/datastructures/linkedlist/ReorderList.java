package com.datastructures.linkedlist;

public class ReorderList {

        public ReverseInKGroups.Node middle(ReverseInKGroups.Node head)
        {
            ReverseInKGroups.Node slow = head;
            ReverseInKGroups.Node fast = head;
            while(fast!=null && fast.next!=null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ReverseInKGroups.Node reverse(ReverseInKGroups.Node head)
        {
            ReverseInKGroups.Node newHead = null;
            while(head!=null)
            {
                ReverseInKGroups.Node node = head;
                head = head.next;
                node.next = newHead;
                newHead = node;
            }
            return newHead;
        }

        public ReverseInKGroups.Node reorderList(ReverseInKGroups.Node head) {

            if(head==null || head.next==null)
            {
                return head;
            }

            ReverseInKGroups.Node mid = middle(head);

            ReverseInKGroups.Node first = head;
            ReverseInKGroups.Node second = reverse(mid.next);
            mid.next=null;

            ReverseInKGroups.Node temp1 = null;
            ReverseInKGroups.Node temp2 = null;

            ReverseInKGroups.Node newHead = first;

            while(second!=null)
            {
                temp1 = first.next;
                temp2 = second.next;
                first.next = second;
                second.next =temp1;
                first = temp1;
                second = temp2;
            }

            return newHead;

        }


}
