package org.example.entity;

public class Instructor {
    private String instructorID;
    private String instructorName;
    private String Courses;

    public Instructor(){

    }

    public Instructor (String instructorID, String instructorName, String Courses) {
        this.instructorID = instructorID;
        this.instructorName = instructorName;
        this.Courses = Courses;
    }

    public String getInstructorID(){
        return instructorID;
    }

    public void setInstructorID(String instructorID){
        this.instructorID = instructorID;
    }

    public String getInstructorName(){
        return instructorName;
    }

    public void setInstructorName(String instructorName){
        this.instructorName = instructorName;
    }

    public String getCourse(){
        return Courses;
    }

    public void setCourse(String Courses){
        this.Courses = Courses;
    }







}
