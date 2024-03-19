package advance.crackingCodingInterview.oops;

import java.util.ArrayList;
import java.util.List;

/**
 * Design and implement a hash table which
 * uses chaining(linked list) to handle collision.
 */
public class Hasher<K, V> {


    // A private static class implemented as a doubly linked list
    private static class LinkedlistNode<K, V>{
        private LinkedlistNode<K, V> prev;
        private LinkedlistNode<K, V> next;
        private K key;
        private V value;

        public LinkedlistNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedlistNode<K, V>> arr;

    public Hasher(int capacity) {
        this.arr = new ArrayList<>();
        arr.ensureCapacity(capacity);

        for(int i = 0; i < capacity; i++){
            arr.add(null);
        }
    }

    // Inset key and value into hash table
    public void put(K key, V value){
        LinkedlistNode<K, V> node = getNodeForKey(key);
        if (node != null){
            node.value = value;
            return;
        }

        node = new LinkedlistNode<K, V>(key, value);
        int index = getIndexForKey(key);
        if(arr.get(index) != null){
            node.next = arr.get(index);
            node.next.prev = node;
        }
        arr.set(index, node);
    }

    // Get value for key
    public V get(K key){
        LinkedlistNode<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public void remove(K key){
        LinkedlistNode<K, V> node = getNodeForKey(key);
        if (node == null) return;

        if (node.prev != null){
            node.prev.next = node.next;
        } else{
            int hashKey = getIndexForKey(key);
            arr.set(hashKey, node.next);
        }
        if (node.next != null)
            node.next.prev = node.prev;
    }


    // Get linkedlist node associated with a given node
    private LinkedlistNode<K, V> getNodeForKey(K key){
        int index = getIndexForKey(key);
        LinkedlistNode<K, V> current = arr.get(index);
        while (current != null){
            if(current.key == key) return current;
            current = current.next;
        }
        return null;
    }
    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % arr.size());
    }
}
