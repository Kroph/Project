package org.example.org.example;

public class ConcreteCourseFactory implements CourseFactory{
    public Course createCourse(int courseId, String courseName, Teacher teacher) {
        return new Course(courseId, courseName, teacher);
    }
}
