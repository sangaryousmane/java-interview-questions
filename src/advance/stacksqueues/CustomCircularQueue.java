package advance.stacksqueues;

public class CustomCircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CustomCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomCircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item; // data[0] = 5
        end = end % data.length;
        size++;
        return true;
    }

    // Remove an element in a circular linked list
    public int remove() {
        if (isEmpty()) {
            throw new StackIsEmptyException("stack is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    // Return the element at the front
    public int front() {
        if (isEmpty()) {
            throw new StackIsEmptyException("queue is empty!");
        }
        return data[front];
    }

    public void display(){
        for (int i = front; i < end; i++) {
            System.out.print(data[i] + "<-");
        }
        System.out.println("END");
    }
}
