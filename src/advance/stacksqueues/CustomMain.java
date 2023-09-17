package advance.stacksqueues;

public class CustomMain {

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(30);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Before: " + q.displayQueue());
        System.out.println("REMOVED: " + q.dequeue());
        System.out.println("After: " + q.displayQueue());
    }
}
