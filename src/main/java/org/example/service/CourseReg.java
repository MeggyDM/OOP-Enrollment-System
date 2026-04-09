package org.example.service;

import org.example.entity.*;

public interface CourseReg {
    void save(Course course);
    void displayAll();
    void updateCourse(Course course);
    void removeCourse(Course course);

}
