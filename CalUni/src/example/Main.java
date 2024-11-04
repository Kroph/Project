package org.example;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static Admin adminAbylay = new Admin(-1,"Abylay","230500@astanait.edu.kz");
    public static Admin adminRassul = new Admin(-2,"Rassul", "230523@astanait.edu.kz");
    public static Admin adminDamir = new Admin(-3,"Damir","230812@astanait.edu.kz");

    public static MenuHandler controller = new MenuHandler(adminAbylay);
    public static void main(String[] args) {
        Information.printAuthors();
        controller.menu();
    }
}