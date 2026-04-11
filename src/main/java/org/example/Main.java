package org.example;
import org.example.entity.Course;
import org.example.entity.*;
import org.example.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TuitionFeePayment tuition = new TuitionFeePayment();
        System.out.println(tuition.calculateTuitionFee(3, 0));
        tuition.makePayment(2000);

        System.out.println(tuition.getBalance());
        System.out.println(tuition.isFullyPaid());

        Person instructor = new Instructor("13","bro","IT");
        instructor.mainTask();

        System.out.println(instructor instanceof Person);

        Scanner input = new Scanner(System.in);
        //ito may switch case
        StudentRegistration SR = new StudentRegistration();
        CourseRegistration CR = new CourseRegistration();
        Registrar registrar = new Registrar(new StudentRegistration(), new CourseRegistration());

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
                    String ID = input.nextLine();

                    System.out.print("Enter Student program: ");
                    String prog = input.nextLine();

                    registrar.saveStudent(new Student(name, ID, prog));
                    registrar.displayAllStudent();
                    break;

                case 2: //display
                    System.out.println("\nHere's the student list.");
                    registrar.displayAllStudent();
                    break;

                case 3: // update
                    System.out.print("Enter the Student ID you want to update: ");
                    String upt = input.nextLine();



                    System.out.print("Enter the Student Name you want to update: ");
                    name = input.nextLine();

                    System.out.print("Enter the Student Program you want to update: ");
                    prog = input.nextLine();


                    if (registrar.updateStudent(new Student(name, upt, prog))) {
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





    }
}