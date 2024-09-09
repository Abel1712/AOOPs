import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        system.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();
            running = executeChoice(choice);
        }
    }

    private void showMenu() {
        System.out.println("\nCustomer Support Ticket System:");
        System.out.println("1. Add Ticket");
        System.out.println("2. Process Ticket");
        System.out.println("3. Display Pending Tickets");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        return scanner.nextInt();
    }

    private boolean executeChoice(int choice) {
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addTicket();
                break;
            case 2:
                processTicket();
                break;
            case 3:
                displayTickets();
                break;
            case 4:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    private void addTicket() {
        System.out.print("Enter ticket description: ");
        String description = scanner.nextLine();
        ticketQueue.add(new Ticket(description));
        System.out.println("Ticket added successfully!");
    }

    private void processTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No tickets to process.");
        } else {
            Ticket ticket = ticketQueue.poll(); // Remove and return the first ticket
            System.out.println("Processed ticket: " + ticket);
        }
    }

    private void displayTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Pending tickets:");
            int index = 1;
            for (Ticket ticket : ticketQueue) {
                System.out.println(index++ + ". " + ticket);
            }
        }
    }
}
class Ticket {
    private String description;

    public Ticket(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
