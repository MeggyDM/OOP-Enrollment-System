package org.example.model;

public class Student {
    private int studentID;
    private String studentName;
    private String program;

    public Student(){
        this("Unknown", 0, "Unknown");
    }

    public Student(String studentName, int studentID, String program){
        this.studentName = studentName;
        this.studentID = studentID;
        this.program = program;
    }

    public void setStudentID(int studentID){

        this.studentID = studentID;
    }

    public int getStudentID(){

        return studentID;
    }

    public void setStudentName(String studentName){

        this.studentName = studentName;
    }

    public String getStudentName(){

        return studentName;
    }

    public void setProgram(String program){

        this.program = program;
    }

    public String getProgram(){

        return program;
    }

    public void sdisplay(){
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Student Name: " + getStudentName());
        System.out.println("Program: " + getProgram() + "\n");
    }


}
