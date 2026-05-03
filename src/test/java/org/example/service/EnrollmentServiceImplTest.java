package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceImplTest {

    @Test
    void shouldRejectEnrollmentWhenSectionIsFull() {
        // Arrange
        Section section = new Section("IT1A", 1, null, new ArrayList<>());
        Student student1 = new Student("Alice", "S1", "IT");
        Student student2 = new Student("Bob", "S2", "IT");

        EnrollmentServiceImpl service = new EnrollmentServiceImpl();

        // Act
        service.enrollStudentInSection(section, student1);
        service.enrollStudentInSection(section, student2);

        // Assert
        assertEquals(1, section.getStudentList().size(), "Section should have blocked the 2nd student.");
    }

}