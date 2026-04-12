package org.example.service;

import org.example.model.Instructor;
import java.util.*;

public interface InstructorReg {
    void save(Instructor instructor);
    void displayAll();
    Instructor findByID(String id);
    void updateInstructor(String id, Instructor updated);
    void deleteInstructor(String id);
}