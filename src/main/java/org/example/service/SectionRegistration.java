package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import java.util.*;

public class SectionRegistration implements SectionReg {

    // Master list of all sections in the system
    private List<Section> sections;

    public SectionRegistration() {
        this.sections = new ArrayList<>();
    }

    @Override
    public void save(Section section) {
        sections.add(section);
        System.out.println("Section " + section.getSectionName() + " saved successfully.");
    }

    @Override
    public List<Section> displayAll() {
        return sections;
    }

    //pang check if may section that matches
    @Override
    public Section findBySectionName(String sectionName) {
        for (Section s : sections) {
            if (s.getSectionName().equalsIgnoreCase(sectionName)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void addStudentToSection(String sectionName, Student student) {
        Section foundSection = findBySectionName(sectionName);

        if (foundSection != null) {
            if (foundSection.getStudentList().size() < 30) {
                foundSection.getStudentList().add(student);
                System.out.println("Student " + student.getPersonName() + " enrolled in " + sectionName);
            } else {
                System.out.println("Cannot enroll: " + sectionName + " has reached the 30-student limit.");
            }
        } else {
            System.out.println("Section not found!");
        }
    }

    @Override
    public void updateSection(String oldName, Section updatedSection) {
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equalsIgnoreCase(oldName)) {
                sections.set(i, updatedSection);
                System.out.println("Section " + oldName + " updated to " + updatedSection.getSectionName());
                return;
            }
        }
    }

    @Override
    public void deleteSection(String sectionName) {
        for (int i = 0; i < sections.size(); i++) {
            // Check if the current section's name matches what we want to delete
            if (sections.get(i).getSectionName().equalsIgnoreCase(sectionName)) {
                sections.remove(i);
                System.out.println("Section " + sectionName + " has been deleted.");
                return; // Stop the loop once we find and delete it
            }
        }
        System.out.println("Delete failed. Section not found.");
    }
}