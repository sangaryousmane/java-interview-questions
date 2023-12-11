package advance;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap data structure is a complete binary tree that satisfies the heap property, where any given node is
 * <p>
 * always greater than its child node/s and the key of the root node is the largest among all other nodes.
 * This property is also called max heap property.
 * always smaller than the child node/s and the key of the root node is the smallest among all other nodes.
 * This property is also called min heap property.
 * This type of data structure is also called a binary heap.
 * <p>
 * Heapify is the process of creating a heap data structure from a binary tree.
 * It is used to create a Min-Heap or a Max-Heap.
 * <p>
 * Peek operation returns the maximum element from Max Heap or minimum element from Min Heap without deleting the node.
 * <p>
 * Heap Data Structure Applications
 * Heap is used while implementing a priority queue.
 * Dijkstra's Algorithm
 * Heap Sort
 * <p>
 * The index of a child element divide by 2 is equal to its parent's index/2
 * Index of the root node is 1
 * Parent = (i - 1) / 2
 * Left = ((2 * i) + 1)
 * Right = ((2 * i) + 2)
 * <p>
 * The value of a given node has to be less than all of its children
 * O(log(n)) for insertion
 * Heap sort - O(Nlog(N))
 */
public class Heaps {

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);
        System.out.println(heap.heapSort());
    }
}

class Heap<T extends Comparable<T>> {

    private ArrayList<T> items;

    public Heap() {
        this.items = new ArrayList<>();
    }

    public void swap(int first, int second) {
        T temp = items.get(first);
        items.set(first, items.get(second));
        items.set(second, temp);
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int right(int index) {
        return index * 2 + 2; // Gives the right side
    }

    public int left(int index) {
        return index * 2 + 1; // Gives the left side
    }

    public void insert(T value) {
        items.add(value);
        upheap(items.size() - 1);
    }

    // Going up the heap
    private void upheap(int index) {
        if (index == 0) return;

        int parent = parent(index);

        // Swap if the current item is smaller than parent
        if (items.get(index).compareTo(items.get(parent)) < 0) {
            swap(index, parent);
            upheap(parent); // Call the parent element
        }
    }

    // Remove the smallest element
    public T remove() throws Exception {
        if (items.isEmpty())
            throw new Exception("Removing from an empty list");

        T temp = items.get(0);
        T lastElement = items.remove(items.size() - 1);
        if (!items.isEmpty()) {
            items.set(0, lastElement);
            downHeap(0);
        }
        return temp;
    }

    // O(log(N))
    private void downHeap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        // if the left element is the minimum element
        if (left < items.size() && items.get(min)
                .compareTo(items.get(left)) > 0) {
            min = left;
        }

        // If the right element is the minimum element
        if (right < items.size() && items.get(min).compareTo(items.get(right)) > 0) {
            min = right;
        }
        // Swap if the minimum element isn't equal the index.
        if (min != index) {
            swap(min, index);
            downHeap(min); // Go downwards
        }
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while (!items.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

    // Construct a max-heap from an unsorted array
    public void maxHeapUnsorted(){

    }
}