package org.example.service;

import org.example.entity.*;

public class Registrar {
    private StudentReg studentRegistration;
    private CourseReg courseRegistration;

    public Registrar(StudentReg studentRegistration, CourseReg courseRegistration) {
        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
    }

    public Registrar() {

    }

    public String saveStudent(Student student){
        studentRegistration.saveStudent(student);
        return "Sucess!";
    }

    public String displayAllStudent(){
        studentRegistration.displayAllStudent();
        return "Sucess!";
    }

    public boolean updateStudent(Student student){
        studentRegistration.updateStudent(student);
        return true;
    }

    public String removeStudent(Student student){
        studentRegistration.removeStudent(student);
        return "Sucess!";
    }

    public String save(Course course){
        courseRegistration.save(course);
        return "Sucess!";
    }

    public String displayAll(){
        courseRegistration.displayAll();
        return "Sucess!";
    }

    public String updateCourse(Course course){
        courseRegistration.updateCourse(course);
        return "Sucess!";
    }

    public String removeCourse(Course course){
        courseRegistration.removeCourse(course);
        return "Sucess!";
    }


}
