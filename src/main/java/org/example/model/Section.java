package org.example.model;

import java.util.*;


public class Section {
    private String sectionName;
    private int maxCapacity;
    private Instructor instructorInCharge;
    private List<Student> studentList;
    private Course course;

    public Section(String sectionName, int maxCapacity, Instructor instructorInCharge, List<Student> studentList) {
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.instructorInCharge = instructorInCharge;
        this.studentList = studentList != null ? studentList : new ArrayList<>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

        if (course != null) {
            System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseID() + ")");
        } else {
            System.out.println("Course: TBA");
        }

        System.out.println("Instructor: " + (instructorInCharge != null ? instructorInCharge.getPersonName() : "TBA"));

        System.out.println("Total Students: " + studentList.size() + "/" + maxCapacity);
        if (studentList.isEmpty()) {
            System.out.println("Student List: (No students enrolled)");
        } else {
            System.out.print("Student List: ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.print(studentList.get(i).getPersonName() + (i < studentList.size() - 1 ? ", " : ""));
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
}
