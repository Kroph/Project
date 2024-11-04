package org.example.org.example;
import java.time.LocalDate;

public class Grade {
    private int gradeValue;
    private LocalDate dateAssigned;
    public Grade(int gradeValue, LocalDate dateAssigned){
        this.gradeValue = gradeValue;
        this.dateAssigned = dateAssigned;
    }
    public int getGradeValue(){
        return gradeValue;
    }
    public LocalDate getDateAssigned(){
        return dateAssigned;
    }
}
