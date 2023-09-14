package advance.stacksqueues;

import java.util.Stack;

public class CustomMain {

    public static void main(String[] args) {
        CustomQueues queue=new CustomQueues(5);
        queue.insert(4);
        queue.insert(5);
        queue.insert(2);
        queue.insert(6);
        queue.display();
    }
}
