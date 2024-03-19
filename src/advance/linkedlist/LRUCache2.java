package advance.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
    // 1. Implement a Node with next and prev, along with (key, value)
    // 2. Initialize the node, a cache and capacity, along with head and tail
    // Head and tail should be -1, -1 in the cache
    // Implement a get to retrieve a node by key when available
    // Implement put to add a new node by key and value if not available and evict if it is LEAST USED
    // Implement add and remove as helpers


    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;


    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        tail = new Node(-1, -1); // Dummy tail
        head = new Node(-1, -1); // Dummy head
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node newNode = cache.get(key);
            removeNode(newNode);
            addNode(newNode);
            return newNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node newNode = cache.get(key);
            newNode.value = value;
            removeNode(newNode);
            addNode(newNode);
        } else {
            if (cache.size() >= capacity){
                cache.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            Node newNode=new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));


//        System.out.println(lRUCache.get(2));
    }
}
