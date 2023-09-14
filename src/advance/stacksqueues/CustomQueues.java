package advance.stacksqueues;

import java.util.Arrays;

public class CustomQueues {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public CustomQueues() {
        this(DEFAULT_SIZE);
    }

    public CustomQueues(int size) {
        this.data = new int[size];
    }

    protected boolean isFull() {
        return end == data.length;
    }

    protected boolean isEmpty() {
        return end == 0;
    }

    // Add element to the queue
    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }

    // Remove an element and shift the rest
    public int remove(int item) throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty");
        }
        return data[0];
    }


    // Display
    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i]+ " <- ");
        }
        System.out.println("END");
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
