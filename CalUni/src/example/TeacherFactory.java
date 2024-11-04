package org.example;

public class TeacherFactory implements UserFactory {
    public User createUser(int id, String name, String email) {
        return new Teacher(id, name, email);
    }
}
