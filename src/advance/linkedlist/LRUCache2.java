//package advance.linkedlist;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LRUCache2 {
//
//    private class ListNode {
//        private int key;
//        private int value;
//        private ListNode next;
//        private ListNode prev;
//
//        public ListNode(int key, int value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        public ListNode() {
//        }
//
//    }
//
//    private int capacity;
//    private Map<Integer, ListNode> cache;
//    private ListNode head;
//    private ListNode tail;
//
//    public LRUCache2(int capacity) {
//        this.capacity = capacity;
//        this.cache = new HashMap<>();
//        head = new ListNode(-1, -1);
//        tail = new ListNode(-1, -1);
//        head.next = tail;
//        tail.prev = head;
//    }
//
//    public int get(int key) {
//        if (cache.containsKey(key)) {
//            ListNode node = cache.get(key);
//            removeFromCache(node);
//            addToFront(node);
//            return node.value;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (cache.containsKey(key)) {
//            ListNode node = cache.get(key);
//            node.value = value;
//            removeFromCache(node);
//            addToFront(node);
//        } else {
//            // Remove the LRU and add a new one
//            if (cache.size() >= capacity) {
//                cache.remove(tail.prev.key);
//                removeFromCache(tail.prev);
//            }
//            ListNode newNode = new ListNode(key, value);
//            cache.put(key, newNode);
//            addToFront(newNode);
//        }
//    }
//
//    private void addToFront(ListNode node) {
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
//        node.prev = head;
//    }
//
//    private void removeFromCache(ListNode node) {
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//    }
//
//    public static void main(String[] args) {
//        LRUCache2 lRUCache = new LRUCache2(2);
//        lRUCache.put(1, 1);
//        lRUCache.put(2, 2);
////        System.out.println(lRUCache.get(1));
//        lRUCache.put(3, 3);
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(4, 4);
//
//        System.out.println(lRUCache.get(2));
//    }
//}
