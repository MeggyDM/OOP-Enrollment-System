package org.example.model;

public class Student extends Person{
    private String program;

    public Student(String PersonName, String PersonID, String program){
        super(PersonName, PersonID);
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


    @Override
    public void mainTask() {
        System.out.println("Student learns");
    }
}
