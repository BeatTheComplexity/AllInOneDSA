package allinonedsa;

import LinkedList.ListNode;
import LinkedList.ReverseList;

public class AllInOneDSA {

    public static void main(String[] args) {
         ListNode head = new ListNode(0);
         head.next = new ListNode(1);
         head.next.next = new ListNode(2);
         head.next.next.next = new ListNode(3);
         
         ListNode current = head;
         while(current != null){
             System.out.print(current.data + " ");
             current = current.next;
         }
         
         head = ReverseList.reverseLinkedList(head);
         
         current = head;
         while(current != null){
             System.out.print(current.data + " ");
             current = current.next;
         }
         
    }

}
