package org.example.service;

import org.example.model.*;
import java.util.*;


public class DepartmentRegistration implements DepartmentReg {
    List<Department> departments;
    List<Instructor> instructors;
    List<Section> sections;


    public DepartmentRegistration(){
        this.departments = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.sections = new ArrayList<>();
    }

    public void save(Department department){
        departments.add(department);

        for (Instructor inst : department.getInstructorList()) {
            instructors.add(inst);
        }

        for (Section sec : department.getSectionList()) {
            sections.add(sec);
        }

        System.out.println("Successfully saved " + department.getDepartmentName());
    }

    public List<Department> displayAll() {
        System.out.println("Displaying " + this.departments.size() + " departments.");
        return this.departments;
    }

}
