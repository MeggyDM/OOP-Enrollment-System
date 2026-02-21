package org.example.service;

import java.util.*;

import org.example.entity.Student;


public class StudentRegistration {
    static Scanner input = new Scanner(System.in);
    private ArrayList<Student> studentList = new ArrayList<>();



    //add
    public void saveStudent(Student student) {
        studentList.add(student);
    }

    //display
    public void displayAllStudent() {
        for (Student s : studentList) {
            System.out.println("\nStudent Name: " + s.getStudentName());
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Program: " + s.getProgram() + "\n");
        }
    }

    //update
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID() == student.getStudentID()) {
                studentList.set(i, student);
                return true;
            }
        }
        return false;
    }

    //removeStudent
    public boolean removeStudent(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentID() == student.getStudentID()) {
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

}

