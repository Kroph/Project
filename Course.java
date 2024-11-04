package org.example.org.example;

import java.util.*;

public class Course {
    private int courseId;
    private String courseName;
    private Teacher teacher;
    private List<Student> students;
    private Map<Student, Grade> grades;
    public Course(int courseId, String courseName, Teacher teacher){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void setGradeForStudent(Student student, Grade grade){
        grades.put(student, grade);
    }
    public Optional<Grade> getGradeForStudent(Student student){
        return Optional.ofNullable(grades.get(student));
    }

}
