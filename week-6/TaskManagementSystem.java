import java.util.ArrayList;
import java.util.Scanner;



public class TaskManagementSystem {
    private ArrayList<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Method to run the menu and handle user choices
    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();
            running = executeChoice(choice);
        }
    }

    // Method to display the menu
    private void showMenu() {
        System.out.println("\nTask Management System:");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Display Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to get the user's choice
    private int getChoice() {
        return scanner.nextInt();
    }

    // Method to execute the user's choice and return whether the system should keep running
    private boolean executeChoice(int choice) {
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                updateTask();
                break;
            case 3:
                removeTask();
                break;
            case 4:
                displayTasks();
                break;
            case 5:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return true;
    }

    // Method to add a new task
    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        taskList.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    // Method to update an existing task
    public void updateTask() {
        displayTasks();
        System.out.print("Enter the position of the task you want to update: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (position >= 1 && position <= taskList.size()) {
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();
            taskList.get(position - 1).setDescription(newDescription);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task position.");
        }
    }

    // Method to remove a task by its position
    public void removeTask() {
        displayTasks();
        System.out.print("Enter the position of the task you want to remove: ");
        int position = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (position >= 1 && position <= taskList.size()) {
            taskList.remove(position - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task position.");
        }
    }

    // Method to display all tasks in the list
    public void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
    }

    // Main method to start the task management system
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();
        tms.start();  // Start the task management system
    }
}
class Task {
    private String description;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
