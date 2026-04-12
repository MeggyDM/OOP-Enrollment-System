package org.example.service;

import org.example.model.*;

public interface CourseReg {
    void save(Course course);
    void displayAll();
    void updateCourse(Course course);
    void removeCourse(Course course);

}
