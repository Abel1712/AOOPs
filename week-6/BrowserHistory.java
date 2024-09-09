import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BrowserHistory {
    private Deque<String> history = new ArrayDeque<>();
    private Deque<String> forwardStack = new ArrayDeque<>();
    private String currentPage = null;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        browser.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();

            if (choice == 1) {
                addPage();
            } else if (choice == 2) {
                goBack();
            } else if (choice == 3) {
                goForward();
            } else if (choice == 4) {
                displayCurrentPage();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nBrowser History:");
        System.out.println("1. Add New Page");
        System.out.println("2. Go Back");
        System.out.println("3. Go Forward");
        System.out.println("4. Display Current Page");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        return scanner.nextInt();
    }

    private void addPage() {
        System.out.print("Enter page URL: ");
        scanner.nextLine(); // Consume newline
        String url = scanner.nextLine();

        if (currentPage != null) {
            history.addLast(currentPage);
        }

        forwardStack.clear(); // Clear forward history when a new page is added
        currentPage = url;
        System.out.println("Added page: " + currentPage);
    }

    private void goBack() {
        if (currentPage == null) {
            System.out.println("No current page.");
        } else if (history.isEmpty()) {
            System.out.println("No pages to go back to.");
        } else {
            forwardStack.addFirst(currentPage);
            currentPage = history.removeLast();
            System.out.println("Went back to page: " + currentPage);
        }
    }

    private void goForward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No pages to go forward to.");
        } else {
            history.addLast(currentPage);
            currentPage = forwardStack.removeFirst();
            System.out.println("Went forward to page: " + currentPage);
        }
    }

    private void displayCurrentPage() {
        if (currentPage == null) {
            System.out.println("No current page.");
        } else {
            System.out.println("Current page: " + currentPage);
        }
    }
}
