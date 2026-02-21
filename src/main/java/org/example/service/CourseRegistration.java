package org.example.service;
import java.util.*;
import org.example.entity.Course;

public class CourseRegistration {
    private ArrayList<Course> courseList = new ArrayList<>();

    //add
    public void save(Course course){
        courseList.add(course);
    }

    //display
    public void displayAll(){
        for (Course c : courseList) {
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Program: " + c.getCourseProgram() + "\n");
        }
    }

    //update
    public void updateCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getCourseID()==course.getCourseID()){
                courseList.set(i, course);
                break;
            }
        }
    }

    //remove
    public void removeCourse(Course course){
        for (int i=0; i<courseList.size();i++){
            if (courseList.get(i).getCourseID()==course.getCourseID()){
                courseList.remove(i);
                break;
            }
        }
    }





}
