package org.example.service;

import org.example.model.Course;
import java.util.List;

public interface CourseReg {
    void save(Course course);
    void displayAll();
    void updateCourse(Course course);
    void removeCourse(String courseID);
    Course findByID(String id);
}