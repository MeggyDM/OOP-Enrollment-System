package org.example.service;

import java.util.*;

import org.example.entity.Person;
import org.example.entity.Student;


public class StudentRegistration extends Person {
    static Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();



    //add
    public void saveStudent(Student student) {
        studentList.add(student);
    }

    //display
    public void displayAllStudent() {
        for (Student s : studentList) {
            System.out.println("\nStudent Name: " + s.getPersonName());
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Program: " + s.getProgram() + "\n");
        }
    }

    //update
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID() == student.getPersonID()) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    //removeStudent
    public boolean removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID() == student.getPersonID()) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public void mainTask() {
        System.out.println("Registers students");
    }
}

