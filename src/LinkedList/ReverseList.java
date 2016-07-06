package linkedlist;

import linkedlist.node.ListNode;

public class ReverseList {

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null, next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
