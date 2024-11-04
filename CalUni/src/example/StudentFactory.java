package org.example;

public class StudentFactory implements UserFactory {
    public User createUser(int id, String name, String email) {
        return new Student(id, name, email);
    }
}
