/**
 * https://www.romaglushko.com/blog/design-lru-cache/
 */
package advance.trees.interviews;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Map<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new ListNode(-1, -1); // Dummy head
        tail = new ListNode(-1, -1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Get the node when it has not been use for the longest time
    public int get(int key) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            removeNode(node); // Remove it
            addToFront(node); // And add it to the front
            return node.value; // Return the value
        }
        return -1; // Return 1 otherwise
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.value = value; // Update value
            removeNode(node);
            addToFront(node);
        } else {
            if (cache.size() >= capacity) { // If the cache has reached maximum capacity
                cache.remove(tail.prev.key);
                removeNode(tail.prev); // Remove the LEAST RECENTLY USED NODE(Last node)
            }
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addToFront(newNode);
        }
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node to index 1(after the head)
    private void addToFront(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/* Second approach
public class LRUCache{
 private int capacity;
    private LinkedHashMap<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cacheMap.put(key, value);
    }
}
 */
