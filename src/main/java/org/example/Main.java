package org.example;
import org.example.entity.Course;
import org.example.entity.Student;
import org.example.service.StudentRegistration;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //ito may switch case
        StudentRegistration SR = new StudentRegistration();

        boolean check = true;


        while (check){

            System.out.println("[1] Save Student");
            System.out.println("[2] Display Student");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");
            System.out.println("[5] Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1: //add
                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Student ID: ");
                    int ID = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Student program: ");
                    String prog = input.nextLine();

                    SR.saveStudent(new Student(name, ID, prog));
                    SR.displayAllStudent();
                    break;

                case 2: //display
                    System.out.println("\nHere's the student list.");
                    SR.displayAllStudent();
                    break;

                case 3: //update
                    System.out.print("Enter the Student ID you want to update: ");
                    int upt = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter the Student Name you want to update: ");
                    name = input.nextLine();

                    System.out.print("Enter the Student Program you want to update: ");
                    prog = input.nextLine();


                    if (SR.updateStudent(new Student(name, upt, prog))) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Error: Student ID " + upt + " not found.");
                    }

                    break;

                case 4: //remove

                    break;


                case 5: //exit

                    check = false;
                    break;
            }
        }





//        Student s = new Student ();
//        Student v = new Student ();
//
//            s.setStudentName("John Doe");
//            s.setStudentID(2022316971);
//            s.setProgram("IT");
//
//
//        v.setStudentName("Jane Doe");
//        v.setStudentID(2015672831);
//        v.setProgram("IT");
//
//        s.sdisplay();
//        v.sdisplay();
//
//        Course a = new Course();
//        Course b = new Course();
//
//        a.setCourseName("Integrative Programming");
//        a.setCourseID(12345);
//        a.setCourseProgram("Information Technology");
//
//        b.setCourseName("Project Management");
//        b.setCourseID(54321);
//        b.setCourseProgram("Information Technology");
//
//        a.cdisplay();
//        b.cdisplay();









    }
}