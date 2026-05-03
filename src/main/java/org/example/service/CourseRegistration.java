package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseRegistration implements CourseReg {
    private ArrayList<Course> courseList = new ArrayList<>();

    @Override
    public void save(Course course) {
        courseList.add(course);
        System.out.println("System: Course " + course.getCourseName() + " has been registered.");
    }

    @Override
    public void displayAll(double pricePerUnit) {
        if (courseList.isEmpty()) {
            System.out.println("No courses registered in the system.");
            return;
        }
        System.out.println("\n--- Available Courses ---");
        for (Course c : courseList) {
            double totalCost = c.getUnits() * pricePerUnit;
            System.out.println("ID: " + c.getCourseID() +
                    " | Name: " + c.getCourseName() +
                    " | Units: " + c.getUnits() +
                    " | Tuition: PHP " + totalCost);
        }
    }

    @Override
    public void updateCourse(Course updatedCourse) {
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCourseID().equalsIgnoreCase(updatedCourse.getCourseID())) {
                courseList.set(i, updatedCourse);
                System.out.println("System: Course " + updatedCourse.getCourseID() + " updated.");
                return;
            }
        }
        System.out.println("Error: Course ID not found.");
    }

    @Override
    public void removeCourse(String courseID) {
        boolean removed = courseList.removeIf(c -> c.getCourseID().equalsIgnoreCase(courseID));
        if (removed) {
            System.out.println("System: Course " + courseID + " removed.");
        } else {
            System.out.println("Error: Course ID not found.");
        }
    }

    @Override
    public Course findByID(String id) {
        for (Course c : courseList) {
            if (c.getCourseID().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}