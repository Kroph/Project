package org.example;

public class Grade {
    private int gradeValue;
    private String dateAssigned;
    public Grade(int gradeValue, String dateAssigned){
        this.gradeValue = gradeValue;
        this.dateAssigned = dateAssigned;
    }
    public int getGradeValue(){
        return gradeValue;
    }
    public void setGradeValue(int gradeValue){
        this.gradeValue = gradeValue;
    }
    public String getDateAssigned(){
        return dateAssigned;
    }
}
