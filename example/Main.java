package org.example;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static void newStudentmenu(Student student) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n+------------ Main Menu ------------+");
        System.out.println("|\t\t\t\t\t\t\t\t    |");
        System.out.println("+---------------+   +---------------+");
        System.out.println("|  [1] Create   |   |  [2] Exit     |");
        System.out.println("+---------------+   +---------------+\n");

        System.out.print("Welcome: " + student.getName() + "! " + "\nPlease select an option: ");
        String op = in.nextLine();

        switch (op) {
            case ("1"):
                createNote(student);
//                viewNote(student);
                break;
            case ("2"):
                exit();
                break;
            default:
                System.out.println("Invalid Input!");
                newStudentmenu(student);
        }
    }

    public static void viewNote(Student student) {
        Scanner in = new Scanner(System.in);
        int counter = 1;
        for (String note : student.getNotes()) {
            System.out.println(counter + ". " + note);
            counter++;
        }
        if (counter <= 1) {
            System.out.println("No notes found containing the search term.");
        }
        System.out.print("Enter any key to go back. ");
        in.nextLine();
    }

    public static void createNote(Student student) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the title of your note: ");
        String title = in.nextLine();
        System.out.print("Enter your note: ");
        String note = in.nextLine();
        student.addNote(title + ": " + note); // Add title and note together
        System.out.println("Note added successfully.");
    }

    public static void exit() {
        System.out.print("\nExiting MemaNotes...");
        System.exit(0);
    }

    public static void enter() {
        Scanner in = new Scanner(System.in);
        String ret, input;
        String no;
        System.out.println("\nPress [2] to go back.");
        System.out.print("Please enter your student no: ");
        no = in.nextLine();

        for (Student student : students) {
            if (Objects.equals(student.getStudentNumber(), no)) {
                if (student.getNotes().size() <= 0) {
                    newStudentmenu(student);
                } else {
                    mainmenu(student);
                }
                mainmenu(student);
            }
        }
        System.out.println("\nStudent does not exist!");
        System.out.println("Create a Student account first.");
        welcome();

//        if (no == 2) {
//            welcome();
//        } else {
//            mainmenu();
//
//        }
        //try {
        // Thread.sleep(1000);
        // } catch(InterruptedException ex) {
        //   Thread.currentThread().interrupt();
        //  }

    }

    public static void welcome() {
        String ret, input;
        Scanner in = new Scanner(System.in);
        System.out.println("\n+------ Welcome to MemaNotes! ------+");
        System.out.println("|                                   | ");
        System.out.println("+---------------+   +---------------+");
        System.out.println("|  [1] Start    |   |   [2] Exit    |");
        System.out.println("+---------------+   +---------------+");
        System.out.println("         +-----------------+          ");
        System.out.println("         | [3] Add Student |          ");
        System.out.println("         +-----------------+          ");
        System.out.print("\nPlease select an option: ");
        input = in.nextLine();

        switch (input) {
            case ("1"):
                enter();
                break;
            case ("2"):
                exit();
                break;
            case ("3"):
                addStudent();
            default:
                System.out.println("Invalid Input!");
                welcome();

        }
    }

    private static void addStudent() {
        Student student = new Student();
        Scanner in = new Scanner(System.in);
        System.out.println("Input student no: ");
        student.setStudentNumber(in.nextLine());
        System.out.println("Input student name: ");
        student.setName(in.nextLine());
        students.add(student);
        System.out.println("Student created successfully!");
        welcome();
    }


    public static void retry() {
        Scanner in = new Scanner(System.in);
        char loop;
        String lo;
        do {
            welcome();
            System.out.println("\nDo you want to continue?");
            System.out.print("Enter Y or N:");
            lo = in.nextLine();
            loop = lo.charAt(0);
        } while (loop == 'Y' || loop == 'y');

    }

//    public static void repeat() {
//        Scanner in = new Scanner(System.in);
//        String ret, input;
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }
//        System.out.println("\nOnly enter numbers [1] or [2]!");
//        System.out.print("\nPlease select an option: ");
//        ret = in.nextLine();
//
//        switch (ret) {
//            case ("1"):
//                enter();
//                input = in.nextLine();
//                break;
//            case ("2"):
//                exit();
//                break;
//            default:
//                repeat();
//
//
//        }
//    }

    public static void mainmenu(Student student) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n+------------ Main Menu ------------+");
        System.out.println("|\t\t\t\t\t\t\t\t    |");
        System.out.println("+---------------+   +---------------+");
        System.out.println("|  [1] Search   |   |  [2] Create   |");
        System.out.println("+---------------+   +---------------+");
        System.out.println("+--------------+    +---------------+");
        System.out.println("|  [3] View    |    |   [4] Edit    |");
        System.out.println("+--------------+    +---------------+");
        System.out.println("+--------------+    +---------------+");
        System.out.println("|  [5] Delete  |    |   [6] Exit    |");
        System.out.println("+--------------+    +---------------+\n");
        System.out.print("Welcome: " + student.getName() + "! " + "\nPlease select an option: ");
        String op = in.nextLine();

        switch (op) {
            case ("1"):
                search(student);
                break;
            case ("2"):
                createNote(student);
                break;
            case ("3"):
                viewNote(student);
                break;
            case ("4"):
                editNote(student);
                break;
            case ("5"):
                deleteNote(student);
                break;
            case ("6"):
                exit();
                break;
            default:
                System.out.println("Invalid Input!");
                mainmenu(student);
        }
        mainmenu(student);
    }

    private static void deleteNote(Student student) {
        Scanner in = new Scanner(System.in);
        int counter = 1;
        for (String note : student.getNotes()) {
            System.out.println(counter + ". " + note);
            counter++;
        }

        String selectedNote = null;

        if(counter <= 1){
            System.out.println("No notes found containing the search term.");
            mainmenu(student);
        }
        else{
            System.out.println("Type [0] if you would like to go back.");
            System.out.print("Please type the number of the note that you would like to delete: ");
            int noteNum = in.nextInt();
            if (noteNum == 0) mainmenu(student);
            try {
                selectedNote = student.getNotes().get(noteNum - 1);
            } catch (Exception ignore) {
            }
            if (selectedNote == null) {
                System.out.println("Invalid input.");
            }
            deleteSelectedNote(student, noteNum - 1);
        }

    }

    public static void deleteSelectedNote(Student student, int selectedNoteIndex) {
        Scanner in = new Scanner(System.in);
        System.out.println("Deleted Successfully!");
        student.getNotes().remove(selectedNoteIndex);
        deleteNote(student);
    }

    public static void editNote(Student student) {
        Scanner in = new Scanner(System.in);
        int counter = 1;
        for (String note : student.getNotes()) {
            System.out.println(counter + ". " + note);
            counter++;
        }

        String selectedNote = null;


        if (counter <= 1) {
            System.out.println("No notes found containing the search term.");
            mainmenu(student);
        } else {
            System.out.println("Type [0] if you would like to go back.");
            System.out.print("Please type the number of the note that you would like to edit: ");
            int noteNum = in.nextInt();
            if (noteNum == 0) mainmenu(student);
            try {
                selectedNote = student.getNotes().get(noteNum - 1);
            } catch (Exception ignore) {
            }

            if (selectedNote == null) {
                System.out.println("Invalid input.");
            }
            editSelectedNote(student, noteNum - 1);
//            System.out.print("Enter new title: ");
//            String title = in.nextLine();
//            System.out.print("Enter new note: ");
//            String note = in.nextLine();
//            selectedNote = title + ": " + note;
        }
//        editNote(student);
    }

    public static void editSelectedNote(Student student, int selectedNoteIndex) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter new title: ");
        String title = in.nextLine();
        System.out.print("Enter new note: ");
        String note = in.nextLine();
        student.getNotes().remove(selectedNoteIndex);
        student.getNotes().add(selectedNoteIndex, title + ": " + note);
        editNote(student);
    }

    public static void search(Student student) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String searchTerm = in.nextLine();
        int counter = 1;
        for (String note : student.getNotes()) {
            if (note.contains(searchTerm)) {
                System.out.println(counter + ". " + note);
                counter++;
            }
        }
        if (counter <= 1) {
            System.out.println("No notes found containing the search term.");
        }
        System.out.print("Enter any key to go back. ");
        in.nextLine();

//        String search, back;
//        char loop;
//        Scanner in = new Scanner(System.in);
//        do {
//            System.out.println("\nType [B] to go back.");
//            System.out.print("Search: ");
//            search = in.nextLine();
//            loop = search.charAt(0);
//
//
//        } while (loop == 'B' || loop == 'b');

    }

    public static void main(String[] args) {
        Student student = new Student("01", "Trial");
        students.add(student);
        Scanner in = new Scanner(System.in);
        welcome();

    }

    public static class Student {
        private String studentNumber;
        private String name;
        private final List<String> notes = new ArrayList<>();

        public Student() {

        }

        public Student(String studentNumber, String name) {
            this.studentNumber = studentNumber;
            this.name = name;
        }

        public String getStudentNumber() {
            return studentNumber;
        }

        public void setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getNotes() {
            return notes;
        }

        public void addNote(String note) {
            notes.add(note);
        }
    }
}