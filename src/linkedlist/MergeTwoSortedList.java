package linkedlist;

import linkedlist.node.ListNode;

public class MergeTwoSortedList {

    public static ListNode mergeSortedList(ListNode headA, ListNode headB) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                current.next = headA;
                headA = headA.next;
            } else {
                current.next = headB;
                headB = headB.next;
            }

            current = current.next;
        }

        if (headA != null) {
            current.next = headA;
        } else if (headB != null) {
            current.next = headB;
        }

        return head.next;
    }

    /*
    to run this method, paste the below in void main
    
    ListNode head = new ListNode(0);
        ListNode current = head;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i+ 1);
            current.next = node;
            current = current.next;
        }
        
        System.out.println("Linked list 1");
        current = head.next;
        while (current != null) {            
            System.out.print(current.data + " ");
            current = current.next;
        }
        
        ListNode head2 = new ListNode(1);
        current = head2;
        for (int i = 1; i < 5; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = current.next;
        }
        
        System.out.println();
        System.out.println("Linked list 2");
        current = head2.next;
        while (current != null) {            
            System.out.print(current.data  + " ");
            current = current.next;
        }
        
        System.out.println();
        System.out.println("Resulted Linked list");
        ListNode sortedHead = MergeTwoSortedList.mergeSortedList(head.next, head2.next);
        current = sortedHead;
        while (current != null) {            
            System.out.print(current.data + " ");
            current = current.next;
        }
     */
}
