package org.example.org.example;

import java.util.ArrayList;
import java.util.List;

public class Student implements User{
    private int id;
    private String name;
    private String email;
    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

}
