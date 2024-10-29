package org.example;

public class Admin implements User {
    private int id;
    private String name;
    private String email;
    public Admin(int id, String name, String email) {
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
    public User createStudent(User userType, int id, String name, String email) {
        return UserFactory.createUser(userType,id,name,email);
    }
}
