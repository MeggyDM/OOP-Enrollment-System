package org.example.service;

import org.example.entity.*;

public class Registrar {
    private StudentReg studentRegistration;
    private CourseReg courseRegistration;
    private DepartmentReg departmentRegistration;

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration) {
        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
        this.departmentRegistration = departmentRegistration;
    }

    public Registrar() {

    }

    public String saveStudent(Student student){
        studentRegistration.saveStudent(student);
        return "Success!";
    }

    public String displayAllStudent(){
        studentRegistration.displayAllStudent();
        return "Success!";
    }

    public boolean updateStudent(Student student){
        studentRegistration.updateStudent(student);
        return true;
    }

    public String removeStudent(Student student){
        studentRegistration.removeStudent(student);
        return "Success!";
    }

    public String save(Course course){
        courseRegistration.save(course);
        return "Success!";
    }

    public String displayAll(){
        courseRegistration.displayAll();
        return "Success!";
    }

    public String updateCourse(Course course){
        courseRegistration.updateCourse(course);
        return "Success!";
    }

    public String removeCourse(Course course){
        courseRegistration.removeCourse(course);
        return "Success!";
    }


}
