package org.example.model;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    public Person(String PersonName, String PersonID) {
        this.PersonName = PersonName;
        this.PersonID = PersonID;
    }

    public Person() {

    }

    public String getPersonID(){
        return PersonID;
    }

    public void setPersonID(String PersonID){
        this.PersonID = PersonID;
    }

    public String getPersonName(){
        return PersonName;
    }

    public void setPersonName(String PersonName){
        this.PersonName= PersonName;
    }

    public abstract void mainTask();
}
