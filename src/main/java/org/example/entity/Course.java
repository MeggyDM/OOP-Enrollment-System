package org.example.entity;

public class Course extends Person{
    private String courseProgram;

    public Course(String PersonID, String PersonName, String courseProgram){
        super(PersonID, PersonName);
        this.courseProgram = courseProgram;
    }



    public void setCourseProgram (String courseProgram){
        this.courseProgram = courseProgram;
    }

    public String getCourseProgram(){
        return courseProgram;
    }

    public void cdisplay(){
        System.out.println("Course ID: " + getPersonID());
        System.out.println("Course Name: " + getPersonName());
        System.out.println("Program: " + getCourseProgram() + "\n");
    }


    @Override
    public void mainTask() {
        System.out.println("Provides subjects");
    }
}
