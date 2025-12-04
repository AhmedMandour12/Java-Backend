
    public class SleepAndJoinTask {

        public static void main(String[] args) {

            // Task: Thread that sleeps
            Thread counterThread = new Thread(() -> {
                System.out.println("--- Counter Started ---");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Count: " + i);
                    try {
                        Thread.sleep(1000); // 1-second delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("--- Counter Finished ---");
            });

            // Task: Second thread for the Join demonstration
            Thread workerThread = new Thread(() -> {
                System.out.println("Worker thread doing a quick job...");
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                System.out.println("Worker thread done.");
            });

            // Start threads
            counterThread.start();
            workerThread.start();

            // Task: Use join() to make main wait
            try {
                System.out.println("Main thread is waiting for workers to finish...");
                counterThread.join(); // Main pauses here until counterThread dies
                workerThread.join();  // Main pauses here until workerThread dies
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("All threads finished. Main thread exiting.");
        }
    }

