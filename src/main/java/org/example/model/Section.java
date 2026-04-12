package org.example.model;

import java.util.*;


public class Section {
    private String sectionName;
    private Instructor instructorInCharge;
    private List<Student> studentList;

    public Section(String sectionName, Instructor instructorInCharge, List<Student> studentList) {
        this.sectionName = sectionName;
        this.instructorInCharge = instructorInCharge;
        this.studentList = studentList;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Instructor getInstructorInCharge() {
        return instructorInCharge;
    }

    public void setInstructorInCharge(Instructor instructorInCharge) {
        this.instructorInCharge = instructorInCharge;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void displaySection() {
        System.out.println("Section: " + sectionName);
        System.out.println("Instructor: " + instructorInCharge.getPersonName());
        System.out.println("Total Students: " + studentList.size());
        System.out.println("Student List: " + studentList + "\n");
    }
}
