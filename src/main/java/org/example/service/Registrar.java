package org.example.service;

import org.example.model.*;

import java.util.*;

public class Registrar {
    private StudentReg studentReg;
    private CourseReg courseReg;
    private DepartmentReg departmentReg;
    private SectionReg sectionReg;
    private TuitionReg tuitionReg;
    private IEnrollmentService enrollmentService;

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration, DepartmentReg departmentRegistration
    , SectionReg sectionRegistration, TuitionReg tuitionRegistration, IEnrollmentService enrollmentService) {
        this.studentReg = studentRegistration;
        this.courseReg = courseRegistration;
        this.departmentReg = departmentRegistration;
        this.sectionReg = sectionRegistration;
        this.tuitionReg = tuitionRegistration;
        this.enrollmentService = enrollmentService;
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

    public void calculateAndSetTuition(Student s, int units) {
        double fee = tuitionReg.calculateTuitionFee(units, 0);
        s.getTuitionDetails().setTotalTuitionFee(fee);
        s.getTuitionDetails().setBalance(fee);
        System.out.println("Tuition set: PHP " + fee);
    }

    public void processPayment(String studentID, double amount) {
        Student s = ((StudentRegistration)studentReg).findByID(studentID);
        if (s != null) {
            tuitionReg.makePayment(s, amount);
        } else {
            System.out.println("Student not found!");
        }
    }

    public void processStudentPayment(String studentID, double amount){
        Student student = ((StudentRegistration)studentReg).findByID(studentID);
        if (student != null) {
            tuitionReg.makePayment(student, amount);
        } else {
            System.out.println("Payment failed: Student not found.");
        }
    }

    public void checkStudentBalance(String studentID) {
        Student student = ((StudentRegistration)studentReg).findByID(studentID);
        if (student != null) {
            double bal = student.getTuitionDetails().getBalance();
            System.out.println("Student: " + student.getPersonName());
            System.out.println("Current Balance: PHP " + bal);
            String status = tuitionReg.isFullyPaid(student) ? "FULLY PAID" : "PENDING";
            System.out.println("Status: " + status);
        } else {
            System.out.println("Student not found!");
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

    public void enrollStudent(Section section, Student student) {
        enrollmentService.enrollStudentInSection(section, student);
    }

    public void displaySectionDetails(String sectionName) {
        Section sec = ((SectionRegistration)sectionReg).findBySectionName(sectionName);
        if (sec != null) {
            System.out.println("\n--- Sections ---");
            System.out.println("Section: " + sec.getSectionName());
            System.out.println("Capacity: " + sec.getStudentList().size() + "/" + sec.getMaxCapacity());

            Instructor ins = sec.getInstructorInCharge();
            System.out.println("Instructor: " + (ins != null ? ins.getPersonName() : "No instructor assigned yet"));

            System.out.println("Enrolled Students:");
            if (sec.getStudentList().isEmpty()) {
                System.out.println("   (No students enrolled)");
            } else {
                for (Student s : sec.getStudentList()) {
                    System.out.println("   - [" + s.getPersonID() + "] " + s.getPersonName());
                }
            }
        } else {
            System.out.println("Section not found.");
        }
    }

    public void displayHierarchy() {
        List<Department> allDepts = departmentReg.displayAll();
        enrollmentService.viewDepartmentHierarchy(allDepts);
    }

    public void saveDept(Department department){
        departmentReg.save(department);
    }

    public void displayAllDepts(){
        List<Department> depts = departmentReg.displayAll();
        System.out.println(depts);
    }


}
