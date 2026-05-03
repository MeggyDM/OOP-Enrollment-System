package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    @Test
    void shouldSaveStudentCorrectly() {
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("Alice", "S1", "IT");

        sr.saveStudent(s1);

        assertEquals(1, sr.getStudentList().size());
        assertEquals("Alice", sr.findByID("S1").getPersonName());
    }

    @Test
    void shouldRemoveStudentCorrectly() {
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("Alice", "S1", "IT");
        sr.saveStudent(s1);

        // Act
        sr.removeStudent(s1);

        // Assert
        assertEquals(0, sr.getStudentList().size(), "List should be empty after removal.");
        assertNull(sr.findByID("S1"));
    }

    @Test
    void shouldNotAddDuplicateStudentIDs() {
        // Arrange
        StudentRegistration sr = new StudentRegistration();
        Student s1 = new Student("Alice", "S1", "IT");
        Student s2 = new Student("Fake Alice", "S1", "CS"); // Same ID!

        // Act
        sr.saveStudent(s1);
        sr.saveStudent(s2);

        // Assert
        assertEquals(1, sr.getStudentList().size(), "The system allowed a duplicate ID to be saved.");
    }

}