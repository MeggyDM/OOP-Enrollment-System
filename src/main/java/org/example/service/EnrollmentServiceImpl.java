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
    public void viewDepartmentHierarchy(List<Department> departments) {
        System.out.println("\n========== INSTITUTIONAL HIERARCHY ==========");

        if (departments == null || departments.isEmpty()) {
            System.out.println("[!] No departments registered in the system.");
            return;
        }

        for (Department dept : departments) {
            System.out.println("\nDepartment: " + dept.getDepartmentName());

            // Check sections
            List<Section> sections = dept.getSectionList();
            if (sections == null || sections.isEmpty()) {
                System.out.println("   └── (No sections assigned)");
            } else {
                for (Section sec : sections) {
                    // Safely get instructor name
                    String instructorName = (sec.getInstructorInCharge() != null)
                            ? sec.getInstructorInCharge().getPersonName()
                            : "No Instructor Assigned";

                    System.out.println("   └── Section: " + sec.getSectionName() + " | Instructor: " + instructorName);

                    // Check students
                    if (sec.getStudentList() == null || sec.getStudentList().isEmpty()) {
                        System.out.println("       └── [No Students Enrolled]");
                    } else {
                        for (Student s : sec.getStudentList()) {
                            System.out.println("       └── Student: [" + s.getPersonID() + "] " + s.getPersonName());
                        }
                    }
                }
            }
        }
        System.out.println("\n=============================================");
    }
}