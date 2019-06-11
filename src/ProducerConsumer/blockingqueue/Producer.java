package ProducerConsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<Object> queue;

    public Producer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
                queue.put(new Task(i));
                System.out.println("生产： " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}