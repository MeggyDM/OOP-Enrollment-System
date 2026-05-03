package org.example.service;

import org.example.model.Department;
import org.example.model.Section;
import org.example.model.Student;
import org.example.model.Instructor;
import java.util.*;

public class EnrollmentServiceImpl implements IEnrollmentService {

    @Override
    public void enrollStudentInSection(Section section, Student student) {
        if (section.getStudentList().size() < section.getMaxCapacity()) {
            section.getStudentList().add(student);
            System.out.println("System: " + student.getPersonName() + " successfully added to " + section.getSectionName());
        } else {
            System.out.println("System Error: Cannot enroll. Section is at full capacity.");
        }
    }

    @Override
    public void viewDepartmentHierarchy(List<Department> allDepts) {
        System.out.println("\n========== INSTITUTIONAL HIERARCHY ==========");

        for (Department dept : allDepts) {
            System.out.println("\nDepartment: " + dept.getDepartmentName());

            if (dept.getSectionList().isEmpty()) {
                System.out.println("   └── (No sections assigned)");
                continue;
            }

            for (Section sec : dept.getSectionList()) {
                String insName = (sec.getInstructorInCharge() != null) ?
                        sec.getInstructorInCharge().getPersonName() : "TBA";

                System.out.println("   └── Section: " + sec.getSectionName() + " | Instructor: " + insName);

                if (sec.getCourse() != null) {
                    System.out.println("       Course: " + sec.getCourse().getCourseName() +
                            " (" + sec.getCourse().getCourseID() + ")");
                } else {
                    System.out.println("       Course: No Course Assigned");
                }

                if (sec.getStudentList().isEmpty()) {
                    System.out.println("       └── (No students enrolled)");
                } else {
                    for (Student s : sec.getStudentList()) {
                        System.out.println("       └── Student: [" + s.getPersonID() + "] " + s.getPersonName());
                    }
                }
            }
        }
        System.out.println("\n=============================================");
    }
}