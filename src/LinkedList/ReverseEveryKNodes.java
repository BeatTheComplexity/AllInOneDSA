package linkedlist;

import linkedlist.node.ListNode;

public class ReverseEveryKNodes {

    public static ListNode reverseEveryKNodes(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null, prev = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;

            count++;
        }

        if (next != null) {
            head.setNext(reverseEveryKNodes(next, k));
        }

        return prev;
    }

}
