package advance.stacksqueues;

public class CustomCircularQueue{
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CustomCircularQueue() {
        this(DEFAULT_SIZE);
    }
    public CustomCircularQueue(int size){
        this.data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void insert(int item){
        if (isFull()){
            throw new StackIsEmptyException("stack is full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
    }

    // Remove an element in a circular linked list
    public int remove(){
        if (isEmpty()){
            throw new StackIsEmptyException("stack is empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    // Return the element at the front
    public int front(){
        if(isEmpty()){
            throw new StackIsEmptyException("queue is empty!");
        }
        return data[front];
    }
}
