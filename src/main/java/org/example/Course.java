package org.example;
import java.util.*;

public class Course {
    private int courseID;
    private String courseName;
    private String courseProgram;

    public Course(){
        this("Unknown", 0, "Unknown");
    }

    public Course (String courseName, int courseID, String courseProgram){
        this.courseName = courseName;
        this.courseID = courseID;
        this.courseProgram = courseProgram;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseID(int courseID){
        this.courseID = courseID;
    }

    public int getCourseID(){
        return courseID;
    }

    public void setCourseProgram (String courseProgram){
        this.courseProgram = courseProgram;
    }

    public String getCourseProgram(){
        return courseProgram;
    }

    public void cdisplay(){
        System.out.println("Course ID: " + getCourseID());
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Program: " + getCourseProgram() + "\n");
    }



}
