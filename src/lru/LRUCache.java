package lru;

import java.util.HashMap;
import java.util.Map;
import lru.node.LRUNode;

public class LRUCache {

    /*
        Design and implement a data structure 
        for Least Recently Used (LRU) cache. 
        It should support the following operations: 
        get and set.

        get(key) - Get the value (will always be positive) 
        of the key if the key exists in the cache, 
        otherwise return -1.
        set(key, value) - Set or insert the value 
        if the key is not already present. 
        When the cache reached its capacity, 
        it should invalidate the least recently used item 
        before inserting a new item.
    
        The key to solve this problem is using 
        a double linked list which enables us 
        to quickly move nodes.
    
        The LRU cache is a hash table of keys and double linked nodes. 
        The hash table makes the time of get() to be O(1). 
        The list of double linked nodes make 
        the nodes adding/removal operations O(1).
     */
    int capacity;
    Map<Integer, LRUNode> map = new HashMap<>();

    LRUNode head = null, end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        if (map.containsKey(key)) {
            LRUNode node = map.get(key);
            removeNode(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void removeNode(LRUNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            end = node.prev;
        }
    }

    private void setHead(LRUNode node) {
         node.next = head;
         node.prev = null;
         
         if (head != null) {
            head.prev = node;
        }
         
        head = node;
        
        if (end == null) {
            end = head;
        }
    }
    
    public void set(Integer key, Integer value){
        if (map.containsKey(key)) {
            LRUNode oldNode = map.get(key);
            oldNode.value = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            LRUNode newNode = new LRUNode(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                removeNode(end);
            }
            
            setHead(newNode);
            map.put(key, newNode);
          
        }
    }
}
