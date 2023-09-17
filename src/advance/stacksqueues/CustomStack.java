package advance.stacksqueues;

import java.util.Arrays;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }


    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    // add or push an item to the stack
    public void push(int item){
        if (isFull()){
            throw new StackIsEmptyException("Stack is full");
        }
//        ptr++;
        data[++ptr] = item; // first increment the pointer before assigning
    }

    // Remove an element from the top of the stack
    public int pop() {
        if (isEmpty()) {
            throw new StackIsEmptyException("Stack is empty");
        }
        return data[ptr--];
    }

    // Return the element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new StackIsEmptyException("can't peek an empty stack");
        }
        return data[ptr];
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
