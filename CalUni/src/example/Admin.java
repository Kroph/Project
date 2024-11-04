package org.example;

import java.util.*;


public class Admin implements User {
    private int id;
    private String name;
    private String email;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Admin> admins;
    private List<Course> courses;
    private UserFactory studentFactory = new StudentFactory();
    private UserFactory teacherFactory = new TeacherFactory();
    private CourseFactory courseFactory = new ConcreteCourseFactory();
    private Map<Student, Set<Course>> studentEnrolledCourses;
    public Admin(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.studentEnrolledCourses = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void addUser(User user) {
        if (user instanceof Teacher) {
            teachers.add((Teacher) user);
        } else if (user instanceof Student) {
            students.add((Student) user);
        } else if (user instanceof Admin) {
            admins.add((Admin) user);
        }
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public User createUser(UserType userType, int id, String name, String email) {
        User user;
        switch (userType) {
            case STUDENT:
                user = studentFactory.createUser(id,name,email);
                break;
            case TEACHER:
                user = teacherFactory.createUser(id,name,email);
                break;
            default:
                throw new IllegalArgumentException("42");
        }
        for (User users : teachers) {
            if (users.getId() == id) {
                System.out.println("User ID " + id + " already exists. Please enter a different ID.");
                return null;
            }
        }
        for (User users : students) {
            if (users.getId() == id) {
                System.out.println("User ID " + id + " already exists. Please enter a different ID.");
                return null;
            }
        }
        for (User users : admins) {
            if (users.getId() == id) {
                System.out.println("User ID " + id + " already exists. Please enter a different ID.");
                return null;
            }
        }
        addUser(user);
        return user;
    }

    public Course createCourse(int courseId, String courseName, Teacher teacher) {
        Course course = courseFactory.createCourse(courseId, courseName, teacher);
        for (Course courses : courses) {
            if (courses.getCourseId() == courseId) {
                System.out.println("Course ID " + id + " already exists. Please enter a different ID.");
                return null;
            }
        }
        addCourse(course);
        return course;
    }

    public List<Student> getAllStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Email: " + student.getEmail());
        }
        return students;
    }

    public List<Teacher> getAllTeachers() {
        System.out.println("List of all teachers:");
        for (Teacher teacher : teachers) {
            System.out.println("ID: " + teacher.getId() + ", Name: " + teacher.getName() + ", Email: " + teacher.getEmail());
        }
        return teachers;
    }
    public void getAllStudentsEnrolledCourses() {
        System.out.println("List of all students and their enrolled courses:");
        for (Student student : students) {
            Set<Course> courses = studentEnrolledCourses.getOrDefault(student, new HashSet<>());
            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() + ", Email: " + student.getEmail());
            if (courses.isEmpty()) {
                System.out.println("No enrolled courses.");
            } else {
                System.out.println("Enrolled Courses:");
                for (Course course : courses) {
                    Optional<Grade> optionalGrade = course.getGradeForStudent(student);
                    String gradeInfo = optionalGrade.isPresent()
                            ? "Grade: " + optionalGrade.get().getGradeValue() +
                            " (Date Assigned: " + optionalGrade.get().getDateAssigned() + ")"
                            : "Grade: Not assigned";
                    System.out.println("Course ID: " + course.getCourseId() +
                            ", Name: " + course.getCourseName() +
                            ", Teacher: " + course.getTeacher().getName() +
                            ", " + gradeInfo);
                }
            }
            System.out.println();
        }
    }

    public List<Course> getAllCourses() {
        System.out.println("List of all courses:");
        for (Course course : courses) {
            System.out.println("Teacher\n" +
                    "  ID: " + course.getTeacher().getId() + "\n" +
                    "  Name: " + course.getTeacher().getName() + "\n" +
                    "  Email: " + course.getTeacher().getEmail() + "\n" +
                    "Course:\n" +
                    "  ID: " + course.getCourseId() + "\n" +
                    "  Name: " + course.getCourseName());
        }
        return courses;
    }



    public void enrollStudentInCourse(Student student, Course course, Optional<Grade> optionalGrade) {
        studentEnrolledCourses.computeIfAbsent(student, k -> new HashSet<>()).add(course);
        course.addStudent(student);
        if (optionalGrade.isPresent()) {
            course.setGradeForStudent(student, optionalGrade.get());
            System.out.println("Student " + student.getName() + " has been enrolled in course " + course.getCourseName() + " with grade " + optionalGrade.get().getGradeValue());
        } else {
            System.out.println("Student " + student.getName() + " has been enrolled in course " + course.getCourseName() + " without a grade.");
        }
    }

}
