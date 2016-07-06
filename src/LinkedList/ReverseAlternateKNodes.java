package linkedlist;

import linkedlist.node.ListNode;

public class ReverseAlternateKNodes {
    
    public static ListNode reverseAlternateKNodes(ListNode head, int k){
        ListNode current = head;
        ListNode next = null , prev = null;
        
        int count = 0;
        while(count < k && current !=null){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            
            count ++;
        }
        
        if (head != null) {
            head.setNext(current);
        }
        
        count = 0;
        while (count < k -1 && current != null) {            
            current = current.getNext();
            count++;
        }
        
        if (current != null) {
            current.setNext(reverseAlternateKNodes(current.getNext(), k));
        }
        
        return prev;
    }
}
