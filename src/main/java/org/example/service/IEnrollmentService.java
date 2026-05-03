package org.example.service;

import org.example.model.Student;
import org.example.model.Section;
import org.example.model.Department;
import java.util.*;

public interface IEnrollmentService {
    void enrollStudentInSection(Section section, Student student);
    void viewDepartmentHierarchy(List<Department> departments);
}