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
    public void push(int item) {
        if (isFull()) {
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



    // https://leetcode.com/problems/flood-fill/
    public static int[][] floodFill(int[][] image, int sr,
                                    int sc, int newColor) {
        if (newColor == image[sr][sc])
            return image;

        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        dfs(image, sr, sc, newColor, rows, cols, source);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int newColor,
                     int rows, int cols, int source) {
        if (sr < 0 || sr >= rows || sc < 0 || sc >= cols)
            return;
        else if (image[sr][sc] != source)
            return;

        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, rows, cols, source); // TOP
        dfs(image, sr + 1, sc, newColor, rows, cols, source); // DOWN
        dfs(image, sr, sc-1, newColor, rows, cols, source); //LEFT
        dfs(image, sr, sc+1, newColor, rows, cols, source); // RIGHT
    }

}
