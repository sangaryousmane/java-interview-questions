package advance.stacksqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/description/
public class QueueToStack {

    private Queue<Integer> first;
    private Queue<Integer> second;

    public QueueToStack(){
        first=new LinkedList<>();
        second=new LinkedList<>();
    }

    public void push(int x){
       while (first.size() > 0)
           second.add(first.poll());

       first.add(x);
       while (second.size() > 0)
           first.add(second.poll());
    }
    public Integer top(){
        return first.peek();
    }
    public int pop(){
        return first.remove();
    }
    public boolean isEmpty(){
        return first.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueToStack{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        QueueToStack queue=new QueueToStack();
        queue.push(4);
        queue.push(3);
        queue.push(5);
        System.out.println("QUEUE: " + queue);
        System.out.println("Topped: "+ queue.top());
        System.out.println("popped: "+ queue.pop());
    }
}
