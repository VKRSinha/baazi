import java.util.LinkedList;
import java.util.Queue;

/**
 * Question 5: Design and implement a stack using queues. Write the complete implementation in core java.
 */
public class CustomStack<T> {
    private Queue<T> queue;
    private Queue<T> helperQueue;


    public CustomStack() {
        this.queue = new LinkedList<T>();
        this.helperQueue = new LinkedList<T>();
    }

    public T peek() {
        T result = pop();
        return this.push(result);
    }

    public synchronized T pop(){
        if(queue.isEmpty())
            throw new IllegalStateException("Stack empty");
        while(queue.size() > 1){
            helperQueue.offer(queue.remove());
        }
        T result = queue.remove();
        Queue<T> temp = helperQueue;
        helperQueue = queue;
        queue = temp;
        return result;
    }

    public synchronized T push(T t){
       queue.add(t);
       return t;
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }


}
