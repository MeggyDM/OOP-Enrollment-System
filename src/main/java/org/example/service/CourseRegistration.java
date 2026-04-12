package org.example.service;
import java.util.*;
import org.example.model.Course;
import org.example.model.Person;

public class CourseRegistration extends Person implements CourseReg{
    private ArrayList<Course> courseList = new ArrayList<>();

    //add
    @Override
    public void save(Course course){
        courseList.add(course);
    }

    //display
    public void displayAll(){
        for (Course c : courseList) {
            System.out.println("Course ID: " + c.getPersonID());
            System.out.println("Course Name: " + c.getPersonName());
            System.out.println("Program: " + c.getCourseProgram() + "\n");
        }
    }

    //update
    @Override
    public void updateCourse(Course course){
        for (int i=0; i<courseList.size(); i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.set(i, course);
                break;
            }
        }
    }

    //remove
    @Override
    public void removeCourse(Course course){
        for (int i=0; i<courseList.size();i++){
            if (courseList.get(i).getPersonID()==course.getPersonID()){
                courseList.remove(i);
                break;
            }
        }
    }


    @Override
    public void mainTask() {
        System.out.println("Registers courses");
    }
}
