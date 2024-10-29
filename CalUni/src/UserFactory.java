package org.example;

public class UserFactory {
    public static User createUser(String userType, int id, String name, String email) {
        switch (userType.toLowerCase()) {
            case "student":
                return new Student(id, name, email);
            case "teacher":
                return new Teacher(id, name, email);
            case "admin":
                return new Admin(id, name, email);
            default:
                throw new IllegalArgumentException("42");
        }
    }
}
