import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ToDoListApp {
    private List<Task> taskList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        app.run();
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
        System.out.println("\nTo-Do List Application:");
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Display Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        return scanner.nextInt();
    }

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

    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        taskList.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    private void updateTask() {
        displayTasks();
        System.out.print("Enter the index of the task you want to update: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < taskList.size()) {
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();
            taskList.get(index).setDescription(newDescription);
            System.out.println("Task updated successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private void removeTask() {
        displayTasks();
        System.out.print("Enter the index of the task you want to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private void displayTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + ". " + taskList.get(i));
            }
        }
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
