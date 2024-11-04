package org.example.org.example;

import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        org.example.org.example.Information.printAuthors();
        Admin admin = new Admin(1, "Admin Name", "admin@example.com");
        MenuHandler menuHandler = new MenuHandler(admin);
        menuHandler.menu();
    }
}