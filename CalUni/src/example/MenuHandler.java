package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuHandler {
    private static Admin admin;
    public MenuHandler(Admin admin){
        this.admin = admin;
    }
    public static void displayMenu() {
        Information.printMenu();
    }
    public static void usersAdd() {
        Scanner sc = new Scanner(System.in);
        Information.printUserInstructions();
        while(sc.hasNextLine()){
            String userRegister = sc.nextLine();
            if(userRegister.equalsIgnoreCase("exit")) {
                System.out.println("Information is saved!");
                break;
            }
            if(userRegister.equalsIgnoreCase("student")) {
                System.out.println("Type Id for Student");
                int id = sc.nextInt();
                sc.nextLine(); // There is nextLine is \n;
                System.out.println("Type Name for Student");
                String name = sc.nextLine();
                System.out.println("Type Email for Student");
                String email = sc.nextLine();
                admin.createUser(UserType.STUDENT, id, name, email);
                System.out.println("Student process initializied!");
                Information.printUserInstructions();
            }
            else if(userRegister.equalsIgnoreCase("teacher")){
                System.out.println("Type Id for Teacher");
                int id = sc.nextInt();
                sc.nextLine(); // There is nextLine is \n;
                System.out.println("Type Name for Teacher");
                String name = sc.nextLine();
                System.out.println("Type Email for Teacher");
                String email = sc.nextLine();
                admin.createUser(UserType.TEACHER, id, name, email);
                System.out.println("Teacher process initializied!");
                Information.printUserInstructions();
            }
            else{
                System.out.println("Invalid input. \nType 'Exit' to return to menu.");
            }
        }
        menu();
    }
    public static void coursesAdd(){
        Scanner sc = new Scanner(System.in);
        Information.printCourseInstructions();
        while(sc.hasNextLine()){
            String courseRegister = sc.nextLine();
            if(courseRegister.equalsIgnoreCase("exit")) {
                System.out.println("Information is saved!");
                break;
            }
            else if(courseRegister.equalsIgnoreCase("course add")) {
                System.out.println("Type Id for Course");
                int courseId = sc.nextInt();
                sc.nextLine(); // There is nextLine is \n;
                System.out.println("Type Name for Course");
                String courseName = sc.nextLine();
                System.out.println("Select Teacher for the Course (enter teacher ID): ");
                Teacher currentTeacher = null;
                List<Teacher> teachers = new ArrayList<>(admin.getAllTeachers());
                while (currentTeacher == null) {
                    int teacherId = sc.nextInt();
                    sc.nextLine(); // Clear the buffer
                    for (Teacher teacher : teachers) {
                        if (teacher.getId() == teacherId) {
                            currentTeacher = teacher;
                            break;
                        }
                    }
                    if (currentTeacher == null) {
                        System.out.println("No teacher found with ID: " + teacherId + ". Please enter a valid teacher ID.");
                    }
                }
                admin.createCourse(courseId, courseName, currentTeacher);
                System.out.println("Course created successfully!");
            }
            else{
                System.out.println("Invalid input. \nType 'course add' to add Course \nor\n Type 'exit' to return to menu.");
            }
        }
        menu();
    }
    public static void enrolledCourseStudents() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Course Enrollment!");
        System.out.println("Enter 'student course add' to enroll a student in a course.");
        System.out.println("Enter 'exit' to return to the main menu.");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Returning to main menu.");
                break;
            }
            if (input.equalsIgnoreCase("student course add")) {
                System.out.println("Enter Student ID to enroll:");
                List<Student> students = new ArrayList<>(admin.getAllStudents());
                int studentId = sc.nextInt();
                sc.nextLine();

                Student student = null;
                for (Student s : students) {
                    if (s.getId() == studentId) {
                        student = s;
                        break;
                    }
                }
                if (student == null) {
                    System.out.println("Student with ID " + studentId + " not found.");
                    continue;
                }
                System.out.println("Enter Course ID for enrollment:");
                List<Course> courses = new ArrayList<>(admin.getAllCourses());
                int courseId = sc.nextInt();
                sc.nextLine();
                Course course = null;
                for (Course c : courses) {
                    if (c.getCourseId() == courseId) {
                        course = c;
                        break;
                    }
                }
                if (course == null) {
                    System.out.println("Course with ID " + courseId + " not found.");
                    continue;
                }
                System.out.println("Do you want to assign a grade? (yes/no)");
                String assignGrade = sc.nextLine();
                Optional<Grade> optionalGrade = Optional.empty();
                if (assignGrade.equalsIgnoreCase("yes")) {
                    System.out.println("Enter Grade Value:");
                    int gradeValue = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Date Assigned (e.g., 2024-11-03):");
                    LocalDate dateAssigned = LocalDate.now();
                    optionalGrade = Optional.of(new Grade(gradeValue, dateAssigned));
                }
                admin.enrollStudentInCourse(student, course, optionalGrade);
                System.out.println("Enrollment process completed.");
            } else {
                System.out.println("Invalid input. Enter 'student course add' to enroll a student or 'exit' to return to the main menu.");
            }
        }
        menu();
    }

    public static void choices(int choice) {
        switch (choice) {
            case 1:
                usersAdd();
                break;
            case 2:
                coursesAdd();
                break;
            case 3:
                enrolledCourseStudents();
                break;
            case 4:
                admin.getAllStudentsEnrolledCourses();
                break;
            case 5:
                admin.getAllCourses();
                break;
            case 6:
                admin.getAllStudents();
                break;
            case 7:
                admin.getAllTeachers();
                break;
            case 0:
                System.exit(0);
        }
        menu();
    }
    public static void menu(){
        displayMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        choices(choice);
    }
}
