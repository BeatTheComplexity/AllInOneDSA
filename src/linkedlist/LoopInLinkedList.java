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
}
