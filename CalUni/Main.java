package org.example;

import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Information.printAuthors();
        Admin adminAbylay = new Admin(-1,"Abylay","230500@astanait.edu.kz");
        MenuHandler menuHandler = new MenuHandler(adminAbylay);
        menuHandler.menu();
    }
}