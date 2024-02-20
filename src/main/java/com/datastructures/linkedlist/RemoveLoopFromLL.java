package com.datastructures.linkedlist;

public class RemoveLoopFromLL {

        public ReverseInKGroups.Node solve(ReverseInKGroups.Node head) {

            ReverseInKGroups.Node slow = head;
            ReverseInKGroups.Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    if (slow == head) {
                        while (fast.next != slow) {
                            fast = fast.next;
                        }
                    } else {
                        slow = head;
                        while (slow.next != fast.next) {
                            slow = slow.next;
                            fast = fast.next;
                        }
                    }
                    fast.next = null;
                }
            }
            return head;
        }


}
