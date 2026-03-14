package org.example.entity;

public abstract class Person {
    private String PersonID;
    private String PersonName;

    public Person(String PersonID, String PersonName){this.PersonID = PersonID;this.PersonName = PersonName;}

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
