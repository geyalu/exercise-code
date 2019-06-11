package ProducerConsumer.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<Object> queue;

    public Consumer(BlockingQueue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            // 获取并处理消息
            while (true) {
                Task task = (Task) queue.take();
                System.out.println("消费馒头： " + task.no);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}