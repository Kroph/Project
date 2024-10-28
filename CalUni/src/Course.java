package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String courseId;
    private String courseName;
    private Teacher teacher;
    private List<Student> students;
    private Map<Student, Grade> grades;
    public Course(String courseId, String courseName, Teacher teacher){
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.grades = new HashMap<>();
    }

}
