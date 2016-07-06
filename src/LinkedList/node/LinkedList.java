package linkedlist.node;

public class LinkedList {

    private int length = 0;
    public ListNode head;

    public LinkedList() {
        length = 0;
    }

    public synchronized ListNode getHead() {
        return head;
    }

    public synchronized void insertAtBegin(ListNode node) {
        node.setNext(head);
        head = node;
        length++;
    }

    public synchronized void insertAtEnd(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode currentnode, nextnode;
            for (currentnode = head; (nextnode = currentnode.getNext()) != null; currentnode = nextnode);
            currentnode.setNext(node);
        }
        length++;
    }

    public void insertAtPos(ListNode node, int pos) {
        if (pos < 0) {
            pos = 0;
        } else if (pos > length) {
            pos = length;
        }

        if (head == null) {
            head = node;
        } else if (pos == 0) {
            node.setNext(head);
            head = node;
        } else {
            ListNode temp = head;
            for (int i = 1; i < pos; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        length++;
    }

    public synchronized void removeFromBegin() {
        if (head != null) {
            head = head.getNext();
            length--;
        }
    }

    public synchronized void removeFromEnd() {
        if (head == null) {
            return;
        }

        ListNode currentNode = head.getNext(), nextNode;
        if (currentNode == null) {
            head = null;
            return;
        }

        while ((nextNode = currentNode.getNext()) != null) {
            currentNode = nextNode;
        }

        currentNode.setNext(null);
    }

    public synchronized void removeFromPos(int pos) {
        if (pos < 0) {
            pos = 0;
        }
        if (pos >= length) {
            pos = length - 1;
        }

        if (head == null) {
            return;
        }

        if (pos == 0) {
            head = head.getNext();
        } else {
            ListNode temp = head;
            for (int i = 0; i < pos; i++) {
                temp = temp.getNext();
            }

            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    public int length() {
        return length;
    }

    public int getPosition(int data) {
        ListNode temp = head;
        int pos = 0;

        while (temp != null) {
            if (temp.getData() == data) {
                return pos;
            }
            pos += 1;
            temp = temp.getNext();
        }

        return Integer.MIN_VALUE;
    }

    @Override
    public String toString() {

        String result = "[";

        if (head == null) {
            return result + "]";
        }

        result = result + head.getData();
        ListNode temp = head.getNext();

        while (temp != null) {
            result = result + "," + temp.getData();
            temp = temp.getNext();
        }

        return result + "]";
    }

}
