package com.datastructures.linkedlist;

public class NodeWhereLoopBegins {

        public ReverseInKGroups.Node detectCycle(ReverseInKGroups.Node head) {

            ReverseInKGroups.Node slow = head;
            ReverseInKGroups.Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    slow = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }

            return null;

        }

}
