package org.example.service;

import org.example.model.*;

import java.util.*;

public class Registrar {
    private StudentReg studentReg;
    private CourseReg courseReg;
    private DepartmentReg departmentReg;
    private SectionReg sectionReg;

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration, DepartmentReg departmentRegistration
    , SectionReg sectionRegistration) {
        this.studentReg = studentRegistration;
        this.courseReg = courseRegistration;
        this.departmentReg = departmentRegistration;
        this.sectionReg = sectionRegistration;
    }

    public Registrar() {

    }

    public void saveStudent(Student student){
        studentReg.saveStudent(student);
        //return "Success!";
    }

    public void displayAllStudent(){
        studentReg.displayAllStudent();
        //return "Success!";
    }

    public boolean updateStudent(Student student){
        boolean success = studentReg.updateStudent(student);
        if (success) {
            System.out.println("Student " + student.getPersonID() + " updated successfully!");
        } else {
            System.out.println("Student ID " + student.getPersonID() + " does not exist!");
        }
        return success;
    }

    public void removeStudent(String id){
        Student found = ((StudentRegistration)studentReg).findByID(id);
        if (found != null) {
            studentReg.removeStudent(found);
            System.out.println("Student and all related data removed!");
        } else {
            System.out.println("Student ID " + id + " does not exist!");
        }
    }

    public void save(Course course){
        courseReg.save(course);
        //return "Success!";
    }

    public void displayAll(){
        courseReg.displayAll();
        //return "Success!";
    }

    public void updateCourse(Course course){
        courseReg.updateCourse(course);
        //return "Success!";
    }

    public void removeCourse(Course course){
        courseReg.removeCourse(course);
        //return "Success!";
    }

    public void saveSection(Section section){
        sectionReg.save(section);
    }

    public void displayAllSections(){
        List<Section> sections = sectionReg.displayAll();
    }

    public void updateSection(String oldName, Section updatedSection){
        sectionReg.updateSection(oldName, updatedSection);
    }

    public void deleteSection(String sectionName){
        sectionReg.deleteSection(sectionName);
    }

    public void enrollStudent(String sectionName, Student student){
        sectionReg.addStudentToSection(sectionName, student);
    }

    public void saveDept(Department department){
        departmentReg.save(department);
    }

    public void displayAllDepts(){
        List<Department> depts = departmentReg.displayAll();
        System.out.println(depts);
    }


}
