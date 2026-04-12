package org.example.service;

import org.example.model.*;

import java.util.*;


public interface SectionReg {
    void save(Section section);

    List<Section> displayAll();
    Section findBySectionName(String sectionName);

    void updateSection(String oldName, Section updatedSection);

    void addStudentToSection(String sectionName, Student student);

    void deleteSection(String sectionName);
}
