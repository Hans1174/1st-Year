package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class main2 {

    static ArrayList<String> notes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nNote Taking Program:");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Edit Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Search Note");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    editNote(scanner);
                    break;
                case 4:
                    deleteNote(scanner);
                    break;
                case 5:
                    searchNote(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addNote(Scanner scanner) {
        System.out.print("Enter the title of your note: ");
        String title = scanner.nextLine();
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(title + ": " + note); // Add title and note together
        System.out.println("Note added successfully.");
    }

    static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            System.out.println("\nYour Notes:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    static void editNote(Scanner scanner) {
        viewNotes();

        if (notes.isEmpty()) {
            return;
        }

        System.out.print("Enter the number of the note to edit: ");
        int noteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (noteIndex >= 0 && noteIndex < notes.size()) {
            // Display the current note content
            System.out.println("Current note content: " + notes.get(noteIndex));

            System.out.print("Enter the new note: ");
            String newNote = scanner.nextLine();
            notes.set(noteIndex, newNote);
            System.out.println("Note edited successfully.");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    static void deleteNote(Scanner scanner) {
        viewNotes();

        if (notes.isEmpty()) {
            return;
        }

        System.out.print("Enter the number of the note to delete: ");
        int noteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (noteIndex >= 0 && noteIndex < notes.size()) {
            notes.remove(noteIndex);
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Invalid note number.");
        }
    }

    static void searchNote(Scanner scanner) {
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).contains(searchTerm)) {
                System.out.println((i + 1) + ". " + notes.get(i));
                found = true;
            }
        }

        if (!found) {

        }
    }
}