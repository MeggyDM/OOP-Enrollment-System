package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student s = new Student ();
        Student v = new Student ();


            s.setStudentName("John Doe");
            s.setStudentID(2022316971);
            s.setProgram("IT");


        v.setStudentName("Jane Doe");
        v.setStudentID(2015672831);
        v.setProgram("IT");

        //s.sdisplay();
        v.sdisplay();

        Course a = new Course();
        Course b = new Course();

        a.setCourseName("Integrative Programming");
        a.setCourseID(12345);
        a.setCourseProgram("Information Technology");

        b.setCourseName("Project Management");
        b.setCourseID(54321);
        b.setCourseProgram("Information Technology");

        a.cdisplay();
        b.cdisplay();









    }
}