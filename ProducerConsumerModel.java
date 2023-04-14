import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Question 4: Implement producer consumer model using threads.
 */
public class ProducerConsumerModel {

    private static Queue<Integer> queue = new LinkedList<>();
    private static final int capacity = 10;

    public static void main(String[] args) {
        Producer producer = new Producer(queue,capacity);
        Consumer consumer = new Consumer(queue);
        Thread produce = new Thread(producer);
        Thread consume = new Thread(consumer);
        produce.start();
        consume.start();
    }

}

class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity;
    private Random random;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
        this.random = new Random();
    }


    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int ele = produce();
                queue.add(ele);
                System.out.println("Producer pushes "+ ele + ".");
                queue.notifyAll();
            }
        }
    }

    /**
     * Function to generate element to produce.
     * @return random integer. Dummy implementation.
     */
    private Integer produce() {
        return random.nextInt();
    }
}

class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                while (queue.size()==0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int ele = queue.poll();
                System.out.println("Consumer consumes "+ ele +".");
                queue.notifyAll();
            }
        }
    }
}
