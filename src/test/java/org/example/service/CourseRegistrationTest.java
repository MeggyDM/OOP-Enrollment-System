package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationTest {

    @Test
    void shouldCorrectlyUpdateCourseInMasterRecord() {
        // 1. Arrange
        CourseRegistration cr = new CourseRegistration();
        Course javaCourse = new Course("CS101", "Java", "IT", 3);
        cr.save(javaCourse);

        // 2. Act
        Course foundCourse = cr.findByID("CS101");
        foundCourse.setUnits(4);

        // 3. Assert
        assertEquals(4, cr.findByID("CS101").getUnits(), "The course units were not updated in the master record.");
    }

}