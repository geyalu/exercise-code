public class TestNotify {

    static class Wait {
        private int counter = 0;
        private String name = null;

        public Wait(int counter, String name) {
            this.counter = counter;
            this.name = name;
        }

        public synchronized void doSomthing() {
            int tempCounter = --counter;
            if (tempCounter <= 0) {
                customizedNotifyAll();
            } else {
                while (tempCounter > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "-<" + name + tempCounter + ">" + "will invoke WAIT()");
                        --tempCounter;
                        wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        notifyAll();
                    }
                    System.out.println(Thread.currentThread().getName() + "-<" + name + tempCounter + ">" + "has been ACTIVED");
                }
                customizedNotifyAll();

            }

        }

        public void customizedNotifyAll() {
            notifyAll();
            System.out.println(Thread.currentThread().getName() + "-<" + name + counter + ">" + "::" + "INVOKED NOTIFYALL() AND FINISHED");
        }

    }

    static class TestThread implements Runnable {
        private Wait wait;

        public TestThread(Wait wait) {
            this.wait = wait;
        }

        public void run() {
            wait.doSomthing();
        }
    }

    public static void main(String[] args) {
        Wait wait = new Wait(4,"DAVID");
        Thread  t1 = new Thread(new TestThread(wait));
        Thread  t2 = new Thread(new TestThread(wait));
        Thread  t3 = new Thread(new TestThread(wait));
        Thread  t4 = new Thread(new TestThread(wait));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
