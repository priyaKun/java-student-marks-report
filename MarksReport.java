import java.util.Scanner;

public class MarksReport {

    // Milestone 3: Return letter grade according to criteria
    public static String gradeFor(int marks) {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 35) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Marks Report ===");
        System.out.print("How many students? ");
        int numStudents = scanner.nextInt();

        // Ensure valid student count
        while (numStudents < 1) {
            System.out.print("Number of students must be at least 1. Try again: ");
            numStudents = scanner.nextInt();
        }

        // Milestone 1: Parallel arrays for names and marks
        String[] names = new String[numStudents];
        int[] marks = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Name of student " + (i + 1) + ": ");
            names[i] = scanner.next();

            System.out.print("Marks (0-100): ");
            int markInput = scanner.nextInt();

            // Milestone 2: Validate mark range [0, 100]
            while (markInput < 0 || markInput > 100) {
                System.out.print("Marks must be from 0 to 100. Try again: ");
                markInput = scanner.nextInt();
            }
            marks[i] = markInput;
        }

        // Milestone 4: Compute total, topper, and pass count
        int totalMarks = 0;
        int topperIndex = 0;
        int passedCount = 0;

        for (int i = 0; i < numStudents; i++) {
            totalMarks += marks[i];

            if (marks[i] > marks[topperIndex]) {
                topperIndex = i;
            }

            if (marks[i] >= 35) {
                passedCount++;
            }
        }

        double average = (double) totalMarks / numStudents;

        // Milestone 5: Output report table and summary
        System.out.println();
        // Format columns: Name (left-aligned 10 chars), Marks (right-aligned 5 chars), Grade (right-aligned 6 chars)
        System.out.printf("%-10s %5s %5s%n", "Name", "Marks", "Grade");
        System.out.println("----------------------");

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10s %5d %5s%n", names[i], marks[i], gradeFor(marks[i]));
        }

        System.out.println("----------------------");
        System.out.printf("Class average: %.2f%n", average);
        System.out.printf("Topper: %s (%d)%n", names[topperIndex], marks[topperIndex]);
        System.out.printf("Passed: %d of %d%n", passedCount, numStudents);

        scanner.close();
    }
}