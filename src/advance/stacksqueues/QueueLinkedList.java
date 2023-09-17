package advance.stacksqueues;

public class QueueLinkedList {
    QNode first, last;

    private class QNode {
        private int data;
        private QNode next;

        public QNode(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "QNode{" +
                    "data=" + data +
                    '}';
        }
    }

    public QueueLinkedList() {
        this.first = this.last = null;
    }

    // Add a new item to the end of the queue - FIFO/LILO
    void enqueue(int data) {
        QNode newNode = new QNode(data);
        if (this.last == null) {
            this.first = this.last = newNode;
            return;
        }
        this.last.next = newNode;
        this.last = newNode;
    }

    // Remove an item from the front of the queue
    int dequeue() {
        if (this.first == null) // Base case
            return 0;

        QNode temp = this.first;
        this.first = this.first.next;


        // The queue becomes empty when the first element is null
        if (this.first == null)
            this.last = null;
        return temp.data;
    }

    // Display the queue's items
    public String displayQueue(){
        QNode temp = this.first;
        StringBuilder sb = new StringBuilder();
        while (temp != null){
            sb.append(temp.data).append(" <- ");
            temp = temp.next;
        }
        sb.append("END");
        return sb.toString();
    }
}
