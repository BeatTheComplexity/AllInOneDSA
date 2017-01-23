package lru.node;

public class LRUNode {

    public int key, value;
    public LRUNode prev, next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
