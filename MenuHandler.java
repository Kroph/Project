package org.example.org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuHandler {
    private EducationFacade educationFacade;

    public MenuHandler(Admin admin) {
        this.educationFacade = new EducationFacade(admin);
    }

    public static void displayMenu() {
        Information.printMenu();
    }

    public void usersAdd() {
        educationFacade.addUsers();
    }

    public void coursesAdd() {
        educationFacade.addCourses();
    }

    public void enrolledCourseStudents() {
        educationFacade.enrolledCoursesStudents();
    }

    public void choices(int choice) {
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
                educationFacade.displayAllEnrolledStudents();
                break;
            case 5:
                educationFacade.displayAllCourses();
                break;
            case 6:
                educationFacade.displayAllStudents();
                break;
            case 7:
                educationFacade.displayAllTeachers();
                break;
            case 0:
                System.exit(0);
        }
        menu();
    }
    public void menu() {
        displayMenu();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        choices(choice);
    }
}