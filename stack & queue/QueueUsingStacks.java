import java.util.Stack;

class MyQueue {
    Stack<Integer> stackEnqueue = new Stack<>();
    Stack<Integer> stackDequeue = new Stack<>();

    // Enqueue operation
    public void enqueue(int x) {
        stackEnqueue.push(x);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        return stackDequeue.pop();
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        return stackDequeue.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }
}

public class QueueUsingStacks {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // Output: 10
        System.out.println(q.peek());    // Output: 20
        System.out.println(q.dequeue()); // Output: 20

        q.enqueue(40);
        System.out.println(q.dequeue()); // Output: 30
        System.out.println(q.dequeue()); // Output: 40
        System.out.println(q.dequeue()); // Output: Queue is empty!
    }
}
