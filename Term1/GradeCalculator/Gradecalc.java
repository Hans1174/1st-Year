package org.example;
import java.util.Scanner;

public class Main {
    public static String passed = "";
    public static String failed = "";

    public static void main(String[] args) {
        int javgd = addJava();
        int cpgd = addcp();
        int phpgd = addPHP();
        System.out.println("\nYou passed your subject(s): " + passed);
        System.out.println("You failed your subject(s): " + failed);
        int ave = (javgd + cpgd + phpgd) / 3;
        String rem;
        if (ave > 61) {
            rem = "Passed!";
        }
        else{
            rem = "Failed!";
        }
        System.out.println("\nYour average grade is: " + ave + " and you " + rem);
    }

    public static int addJava() {
        String sub = "Java";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your grade in Java: ");
        int grade = in.nextInt();

        if (grade <= 60) {
            if (failed == "") {
                failed = failed + sub;
            } else {
                failed = failed + ", " + sub;
            }
        }else {
            if (passed == "") {
                passed = passed + sub;
            } else {
                passed = passed + ", " + sub;
            }

        }
        return grade;
    }

    public static int addcp() {
        String sub = "C++";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your grade in C++: ");
        int grade = in.nextInt();

        if (grade <= 60) {
            if (failed == "") {
                failed = failed + sub;
            } else {
                failed = failed + ", " + sub;
            }
        }else {
            if (passed == "") {
                passed = passed + sub;
            } else {
                passed = passed + ", " + sub;
            }

        }
        return grade;
    }

    public static int addPHP() {
        String sub = "PHP";
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your grade in PHP: ");
        int grade = in.nextInt();

        if (grade <= 60) {
            if (failed == "") {
                failed = failed + sub;
            } else {
                failed = failed + ", " + sub;
            }
        }else {
            if (passed == "") {
                passed = passed + sub;
            } else {
                passed = passed + ", " + sub;
            }

        }
        return grade;
    }
}