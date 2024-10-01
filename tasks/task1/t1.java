package tasks.task1;

public class t1 {
     
        public static void main(String[] args) {
            // Trying to get instances of the Logger
            Logger logger1 = Logger.getInstance();
            Logger logger2 = Logger.getInstance();
    
            // Both references should point to the same instance
            System.out.println(logger1 == logger2); // Output: true
    
            // Logging messages using the logger instance
            logger1.log("This is the first log message.");
            logger2.log("This is the second log message.");
        }
    
    
}
 class Logger {
    // Step 1: Create a private static instance of the class (lazy initialization)
    private static Logger instance;

    // Step 2: Make the constructor private to prevent instantiation from other classes
    private Logger() {
        // Optional: Initialize resources like log files, connections, etc.
    }

    // Step 3: Provide a public static method to get the instance (global access point)
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Lazy initialization - creates the instance only when required
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        // Here you can write the log message to a file or display it in the console
        System.out.println("Log message: " + message);
    }
}
