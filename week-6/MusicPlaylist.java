import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MusicPlaylist {
    private List<String> playlist = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.run();
    }

    private void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();

            if (choice == 1) {
                addSong();
            } else if (choice == 2) {
                removeSong();
            } else if (choice == 3) {
                moveSong();
            } else if (choice == 4) {
                displayPlaylist();
            } else if (choice == 5) {
                System.out.println("Exiting...");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nMusic Playlist:");
        System.out.println("1. Add Song");
        System.out.println("2. Remove Song");
        System.out.println("3. Move Song");
        System.out.println("4. Display Playlist");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getChoice() {
        return scanner.nextInt();
    }

    private void addSong() {
        System.out.print("Enter song name: ");
        scanner.nextLine(); // Consume newline
        String song = scanner.nextLine();
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

    private void removeSong() {
        System.out.print("Enter song name to remove: ");
        scanner.nextLine(); // Consume newline
        String song = scanner.nextLine();

        if (playlist.remove(song)) {
            System.out.println("Removed song: " + song);
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    private void moveSong() {
        System.out.print("Enter song name to move: ");
        scanner.nextLine(); // Consume newline
        String song = scanner.nextLine();

        if (!playlist.contains(song)) {
            System.out.println("Song not found in the playlist.");
            return;
        }

        System.out.print("Enter new position (0-based index): ");
        int newPosition = scanner.nextInt();

        if (newPosition < 0 || newPosition >= playlist.size()) {
            System.out.println("Invalid position.");
            return;
        }

        playlist.remove(song);
        ((LinkedList<String>) playlist).add(newPosition, song);
        System.out.println("Moved song: " + song + " to position " + newPosition);
    }

    private void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Current playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println(i + ". " + playlist.get(i));
            }
        }
    }
}
