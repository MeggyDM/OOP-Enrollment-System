package org.example.model;

public class Instructor extends Person{

    private String courses;

    public Instructor(String PersonName, String PersonID, String courses){
        super(PersonName, PersonID);
        this.courses = courses;
    }

    public String getCourse(){
        return courses;
    }

    public void setCourse(String courses){
        this.courses = courses;
    }


    @Override
    public void mainTask() {
        System.out.println(getPersonName() + " is an instructor who teaches: " + courses);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "Name='" + getPersonName() + '\'' +
                ", ID='" + getPersonID() + '\'' +
                ", Courses='" + courses + '\'' +
                '}';
    }

}
