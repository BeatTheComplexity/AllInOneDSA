package linkedlist.node;

public class ListNode {

    public int data;
    public ListNode next;
    
    public ListNode(int data){
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return this.next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
