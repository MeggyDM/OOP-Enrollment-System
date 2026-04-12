package org.example.service;

import java.util.*;

import org.example.model.Person;
import org.example.model.Student;


public class StudentRegistration extends Person implements StudentReg {
    static Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();



    //add
    @Override
    public void saveStudent(Student student) {
        studentList.add(student);
    }

    //display
    @Override
    public void displayAllStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : studentList) {
            System.out.println("\nStudent Name: " + s.getPersonName());
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Program: " + s.getProgram() + "\n");
        }
    }
    //for validation
    public Student findByID(String id) {
        for (Student s : studentList) {
            if (s.getPersonID().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    //update
    @Override
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equalsIgnoreCase(student.getPersonID())) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    //removeStudent
    @Override
    public boolean removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getPersonID().equalsIgnoreCase(student.getPersonID())) {
                studentList.remove(i);
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

