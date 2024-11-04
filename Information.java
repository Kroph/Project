package org.example.org.example;

public class Information {
    public static void printAuthors() {
        System.out.println("Project Authors:");
        System.out.println("1. Damir");
        System.out.println("2. Abylay");
        System.out.println("3. Rassul");
    }
    public static void printMenu(){
        System.out.println("\nWhat do you want my Lord");
        System.out.println("1. Create a User");
        System.out.println("2. Create a Course");
        System.out.println("3. Create enrolledCourseStudents");
        System.out.println("4. View All Enrolled Course Students");
        System.out.println("5. View Active Courses");
        System.out.println("6. View All Students");
        System.out.println("7. View All Teachers");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
    public static void printUserInstructions(){
        System.out.println("Write 'exit' if you want to stop...");
        System.out.println("Available roles: Student,Teacher.");
    }
    public static void printCourseInstructions(){
        System.out.println("Welcome to the Course Editor!");
        System.out.println("Write 'course add' if you want to add Course.");
        System.out.println("Write 'exit' if you want to stop.");
    }
}
