public class Q9b {
    
        public static void main(String[] args) {
            BankAccount account = new BankAccount(1000); // Initial balance
    
            // Create multiple threads simulating deposit and withdrawal
            Thread t1 = new UserThread(account, true);  // Depositing
            Thread t2 = new UserThread(account, false); // Withdrawing
            Thread t3 = new UserThread(account, true);  // Depositing
            Thread t4 = new UserThread(account, false); // Withdrawing
    
            // Start threads
            t1.start();
            t2.start();
            t3.start();
            t4.start();
    
            // Wait for all threads to finish
            try {
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // Print final balance
            System.out.println("Final Balance: " + account.getBalance());
        }
    }
    

 class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Deposit method with synchronization to ensure thread safety
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        }
    }

    // Withdraw method with synchronization to ensure thread safety
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal: " + amount);
        }
    }

    // Getter for balance
    public synchronized double getBalance() {
        return balance;
    }
}
 class UserThread extends Thread {
    private BankAccount account;
    private boolean deposit;

    // Constructor
    public UserThread(BankAccount account, boolean deposit) {
        this.account = account;
        this.deposit = deposit;
    }

    @Override
    public void run() {
        if (deposit) {
            account.deposit(100); // Example deposit amount
        } else {
            account.withdraw(50); // Example withdrawal amount
        }
    }
}

