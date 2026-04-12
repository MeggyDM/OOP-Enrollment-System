package org.example.service;

import org.example.model.Instructor;
import java.util.List;

public class HR {
    private InstructorReg instructorReg;

    public HR(InstructorReg instructorReg) {
        this.instructorReg = instructorReg;
    }

    public void addInstructor(Instructor instructor) {
        instructorReg.save(instructor);
    }

    public void displayAllInstructors() {
        instructorReg.displayAll();
    }

    public void updateInstructorDeets(String id, Instructor updated) {
        if (((InstructorRegistration)instructorReg).findByID(id) != null) {
            instructorReg.updateInstructor(id, updated);
            System.out.println("Instructor updated!");
        } else {
            System.out.println("Instructor ID not found.");
        }
    }

    public void getAllInstructors() {
        instructorReg.displayAll();
    }

    public void removeInstructor(String id) {
        if (((InstructorRegistration)instructorReg).findByID(id) != null) {
            instructorReg.deleteInstructor(id);
            System.out.println("Instructor removed!");
        } else {
            System.out.println("Instructor ID not found.");
        }
    }
}