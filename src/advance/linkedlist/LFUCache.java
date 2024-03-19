package advance.linkedlist;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {

    private class ListNode {
        private int key;
        private int value;
        private int frequency;

        private ListNode next;
        private ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private int capacity;
    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        tail = new ListNode(-1, -1);
        head = new ListNode(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.frequency++;
            removeNode(node);
            addFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.value = value;
            node.frequency++;
            removeNode(node);
            addFront(node);
        }
        else {
            if (cache.size() >= capacity){
                if (tail.prev.frequency <= 0){
                    cache.remove(tail.prev.key);
                    removeNode(tail.prev);
                }
                else {
                    ListNode node = new ListNode(key, value);
                    cache.put(key, node);
                    addFront(node);
                }
            }
        }
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFront(ListNode node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

}
