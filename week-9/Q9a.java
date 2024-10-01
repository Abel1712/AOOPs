public class Q9a {

        private static final Object lock = new Object();
    
        public static void main(String[] args) {
            Thread printTwoThread = new Thread(new PrintTwo());
            Thread printThreeThread = new Thread(new PrintThree());
            Thread printFourThread = new Thread(new PrintFour());
            Thread printFiveThread = new Thread(new PrintFive());
            Thread printNumberThread = new Thread(new PrintNumber());
    
            printTwoThread.start();
            printThreeThread.start();
            printFourThread.start();
            printFiveThread.start();
            printNumberThread.start();
        }
    
        static class PrintTwo implements Runnable {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println(i + " is divisible by 2");
                        }
                    }
                }
            }
        }
    
        static class PrintThree implements Runnable {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    synchronized (lock) {
                        if (i % 3 == 0) {
                            System.out.println(i + " is divisible by 3");
                        }
                    }
                }
            }
        }
    
        static class PrintFour implements Runnable {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    synchronized (lock) {
                        if (i % 4 == 0) {
                            System.out.println(i + " is divisible by 4");
                        }
                    }
                }
            }
        }
    
        static class PrintFive implements Runnable {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    synchronized (lock) {
                        if (i % 5 == 0) {
                            System.out.println(i + " is divisible by 5");
                        }
                    }
                }
            }
        }
    
        static class PrintNumber implements Runnable {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    boolean printed = false;
                    synchronized (lock) {
                        // Check divisibility by 2, 3, 4, and 5
                        if (i % 2 == 0 || i % 3 == 0 || i % 4 == 0 || i % 5 == 0) {
                            printed = true;
                        }
                        if (!printed) {
                            System.out.println(i + " is not divisible by 2, 3, 4, or 5");
                        }
                    }
                }
            }
        }
    }
    

