package linkedlist;

import linkedlist.node.ListNode;

public class LoopInLinkedList {

    public static boolean checkWeatherLoopExist(ListNode head) {

        ListNode slrPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slrPtr = slrPtr.next;

            if (slrPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public static ListNode startingPointOfLoop(ListNode head) {
        ListNode slrPtr = head;
        ListNode fastPtr = head;

        boolean isLoop = false;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slrPtr = slrPtr.next;

            if (slrPtr == fastPtr) {
                isLoop = true;
                break;
            }
        }

        if (isLoop) {
            slrPtr = head;

            while (slrPtr != fastPtr) {
                slrPtr = slrPtr.next;
                fastPtr = fastPtr.next;
            }

            return slrPtr;
        }

        return null;
    }

    /*
        To the run the above prog, paste below code in void main
    
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
     */
}
