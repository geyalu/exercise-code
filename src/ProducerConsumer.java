import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private static Queue queue = new LinkedList();

    static class Producer implements Runnable {

        @Override
        public void run() {

            while (true) {

                synchronized (queue){

                if (queue.size() < 10) {

                    for (int i = 0; i < 10; i++) {
                        queue.offer(i);
                        System.out.println("add to queue:"+ i);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    System.out.println("producer start notify ");
                    queue.notify();
                } else {
                    try {
                        System.out.println("producer start wait ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }}


        }
    }


    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {

                synchronized (queue){

                if (queue.size() <= 0) {
                    try {
                        System.out.println("comsumer start wait ");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("comsumer clean queue ");
                    queue.clear();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                System.out.println("comsumer start notify ");
                queue.notify();
            }}
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Consumer());
        Thread thread2 = new Thread(new Producer());

        thread1.start();
        thread2.start();
    }

}
