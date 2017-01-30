package allinonedsa;

import linkedlist.LoopInLinkedList;
import linkedlist.node.ListNode;

public class AllInOneDSA {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);
        ListNode ten = new ListNode(10);
        
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = four;
        
        System.out.println(LoopInLinkedList.checkWeatherLoopExist(head));
        System.out.println(LoopInLinkedList.startingPointOfLoop(head).data);
    }
}
