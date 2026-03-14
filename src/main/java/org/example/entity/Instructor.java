package org.example.entity;

public class Instructor extends Person{

    private String COURSES;

    public Instructor(String PersonID, String PersonName, String courses){
        super(PersonID, PersonName);
        COURSES = courses;
    }

    public String getCourse(){
        return COURSES;
    }

    public void setCourse(String COURSES){
        this.COURSES = COURSES;
    }


    @Override
    public void mainTask() {
        System.out.println("Instructor teaches");
    }
}
