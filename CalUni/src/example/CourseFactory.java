package org.example;

public interface CourseFactory {
    Course createCourse(int courseId, String courseName, Teacher teacher);
}
