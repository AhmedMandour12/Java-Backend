class BasicThreadCreation {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from thread (Extended Class)");
        }
    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " | Message: Implementation Successful");
        }
    }
void main() {


            MyThread t1 = new MyThread();
            t1.start();

            Thread t2 = new Thread(new MyRunnable());
            t2.start();
        }
    }

