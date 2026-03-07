package org.example.entity;

public class Student extends Person{
    private String program;

    public Student(String PersonID, String PersonName, String program){
        super(PersonID, PersonName);
        this.program = program;
    }



    public void setProgram(String program){

        this.program = program;
    }

    public String getProgram(){

        return program;
    }

    public void sdisplay(){
        System.out.println("Student ID: " + getPersonID());
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Program: " + getProgram() + "\n");
    }


}
