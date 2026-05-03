package org.example.model;

public class Student extends Person{
    private String program;
    private TuitionFeePayment tuitionDetails;

    public Student(String PersonName, String PersonID, String program){
        super(PersonName, PersonID);
        this.program = program;
        this.tuitionDetails = new TuitionFeePayment(0);
    }

    public void setProgram(String program){

        this.program = program;
    }

    public String getProgram(){

        return program;
    }

    public TuitionFeePayment getTuitionDetails(){
        return tuitionDetails;
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
