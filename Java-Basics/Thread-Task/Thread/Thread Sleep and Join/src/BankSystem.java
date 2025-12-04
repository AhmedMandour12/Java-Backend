class BankAccount {
    private int balance = 0;

    // Synchronized: Only one thread can deposit at a time
    public synchronized void deposit(int amount) {
        System.out.println(" [Depositor] trying to deposit $" + amount);
        balance += amount;
        System.out.println(" [Depositor] Success! New Balance: $" + balance);

        // Notify the waiting thread (Withdrawer) that state has changed
        notify();
    }

    // Synchronized: Only one thread can withdraw at a time
    public synchronized void withdraw(int amount) {
        System.out.println(" [Withdrawer] trying to withdraw $" + amount);

        // Check logic inside a while loop (standard pattern for wait)
        while (balance < amount) {
            System.out.println(" [Withdrawer] Insufficient funds ($" + balance + "). Waiting for deposit...");
            try {
                wait(); // Releases lock and pauses until notify() is called
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Proceed once balance is sufficient and thread wakes up
        balance -= amount;
        System.out.println(" [Withdrawer] Success! Withdrew $" + amount + ". Remaining Balance: $" + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create Depositor Thread
        Thread depositor = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000); // Simulate time passing between deposits
                    account.deposit(100);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        // Create Withdrawer Thread
        Thread withdrawer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    // Start immediately or wait slightly longer to simulate need
                    Thread.sleep(1500);
                    account.withdraw(100);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        });

        // Start threads
        withdrawer.start();
        depositor.start();
    }
}