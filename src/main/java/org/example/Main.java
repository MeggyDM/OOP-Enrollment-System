package org.example;
import org.example.model.*;
import org.example.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        TuitionFeePayment tuition = new TuitionFeePayment();
//        System.out.println(tuition.calculateTuitionFee(3, 0));
//        tuition.makePayment(2000);
//
//        System.out.println(tuition.getBalance());
//        System.out.println(tuition.isFullyPaid());
//
//        Person instructor = new Instructor("13","bro","IT");
//        instructor.mainTask();
//
//        System.out.println(instructor instanceof Person);

        //services
        StudentRegistration SR = new StudentRegistration();
        CourseRegistration CR = new CourseRegistration();
        DepartmentRegistration DR = new DepartmentRegistration();
        SectionRegistration SRS = new SectionRegistration();
        InstructorRegistration IR = new InstructorRegistration();

        //controllers
        Registrar registrar = new Registrar(SR, CR, DR, SRS);
        HR hr = new HR(IR);

        Scanner input = new Scanner(System.in);
        boolean check = true;


        while (check){

            System.out.println("\n========================");
            System.out.println("      CAMPUS PORTAL      ");
            System.out.println("========================");
            System.out.println("[1] Registrar (Student/Section/Department Registrations");
            System.out.println("[2] HR (Instructor Registration)");
            System.out.println("[3] Exit portal");
            System.out.print("Select Portal: ");

            int pChoice = input.nextInt();
            input.nextLine();

            if (pChoice ==1){
                boolean regLoop = true;
                while (regLoop){
                    System.out.println("\n===WELCOME TO THE REGISTRAR PORTAL===");
                    System.out.println("[1] Save Student\n[2] Display All Students\n[3] Update Student\n[4] Remove" +
                            "Student\n[5] Create Section\n" +
                            "[6] Enroll Student in Section\n[7] Back to Main");
                    System.out.print("Select Option: ");
                    int regOption = input.nextInt();
                    input.nextLine();

                    switch (regOption){
                        case 1:
                            System.out.print("Enter Student Name: ");
                            String name = input.nextLine();

                            System.out.print("Enter Student ID: ");
                            String ID = input.nextLine();

                            System.out.print("Enter Student program: ");
                            String prog = input.nextLine();

                            registrar.saveStudent(new Student(name, ID, prog));
                            break;
                        case 2:
                            System.out.println("\n===Here's the list of Students===");
                            registrar.displayAllStudent();
                            break;
                        case 3:
                            System.out.print("Enter Student ID to update: ");
                            String uID = input.nextLine();

                            if (SR.findByID(uID) != null) {
                                System.out.print("New Name: "); String uName = input.nextLine();
                                System.out.print("New Program: "); String uProg = input.nextLine();
                                registrar.updateStudent(new Student(uName, uID, uProg));
                            } else {
                                System.out.println("Student ID " + uID + " not found!");
                            }

//                            if (registrar.updateStudent(new Student(uName, uID, uProg))) {
//                                System.out.println("Update Success!");
//                            } else {
//                                System.out.println("Student ID not found.");
//                            }
                            break;
                        case 4:
                            System.out.print("Enter Student ID to remove: ");
                            String rID = input.nextLine();
                            registrar.removeStudent(rID);
                            break;

                        case 5:
                            System.out.print("New Section Name: ");
                            String newSection = input.nextLine();
                            registrar.saveSection(new Section(newSection, null, new ArrayList<>()));
                            break;
                        case 6:
                            System.out.print("Enter Section Name for Enrollment: ");
                            String secName = input.nextLine();

                            Section foundSec = SRS.findBySectionName(secName);

                            if (foundSec == null){
                                System.out.println("Section " + secName + " not found!");
                                System.out.print("Would you like to create one now? (y/n): ");
                                String ans = input.nextLine();

                                if (ans.equalsIgnoreCase("y")){
                                    registrar.saveSection(new Section(secName, null, new ArrayList<>()));
                                    System.out.println("Section successfully created! Please enroll again!");
                                }
                            } else {
                                boolean enrollDone = false;

                                while (!enrollDone) {
                                    System.out.print("\nEnter Student ID to enroll: ");
                                    String sID = input.nextLine();

                                    Student record = SR.findByID(sID);

                                    if (record == null) {
                                        System.out.println("Student ID " + sID + " is not registered in the system!");
                                        System.out.print("Try a different ID? (y/n): ");
                                        if (input.nextLine().equalsIgnoreCase("n")){
                                            break;
                                        }
                                        continue;
                                    }

                                    System.out.print("Enter Student Name: ");
                                    String sName = input.nextLine();
                                    if (!sName.equalsIgnoreCase(record.getPersonName())) {
                                        System.out.println("Name does not match the records for ID " + sID + ". Please " +
                                                "check for typos.");
                                        continue;
                                    }

                                    // 3. Validate Program (Matches the record)
                                    System.out.print("Enter Student Program: ");
                                    String sProg = input.nextLine();
                                    if (!sProg.equalsIgnoreCase(record.getProgram())) {
                                        System.out.println("Program does not match the records for ID " + sID + ". Please " +
                                                "check for typos.");
                                        continue;
                                    }

                                    registrar.enrollStudent(secName, new Student(sName, sID, sProg));
                                    enrollDone = true;
                                }
                            }
                            break;
                        case 7:
                            regLoop = false;
                            break;

                    }

                }

            } else if (pChoice == 2){
                boolean hrLoop = true;
                while (hrLoop){
                    System.out.println("\n===WELCOME TO THE HR PORTAL===");
                    System.out.println("[1] Hire Instructors\n[2] Display All Intructors\n[3] Update Instructor\n[4] " +
                                    "Remove Instructor\n[5] Back to Main\n");
                    System.out.print("Select Option: ");
                    int hrOption = input.nextInt();
                    input.nextLine();

                    switch (hrOption){
                        case 1:
                            System.out.print("Instructor ID: ");
                            String iID = input.nextLine();

                            System.out.print("Instructor Name: ");
                            String iName = input.nextLine();

                            System.out.print("Instructor Course: ");
                            String iCourse = input.nextLine();
                            hr.addInstructor(new Instructor(iName, iID, iCourse));
                            break;
                        case 2:
                            System.out.println("\n===Here's the list of Instructors===");
                            hr.displayAllInstructors();
                            break;
                        case 3:
                            System.out.print("Enter Instructor ID to update: ");
                            String upID = input.nextLine();

                            if (IR.findByID(upID) != null) {
                                System.out.print("New Name: ");
                                String un = input.nextLine();
                                System.out.print("New Course: ");
                                String uc = input.nextLine();
                                hr.updateInstructorDeets(upID, new Instructor(upID, un, uc));
                            } else {
                                System.out.println("Instructor ID not found.");
                            }
                            break;
                        case 4:
                            System.out.print("Enter Instructor ID to remove: ");
                            String deleteID = input.nextLine();
                            hr.removeInstructor(deleteID);
                            break;
                        case 5:
                            hrLoop = false;
                            break;


                    }


                }


            } else if (pChoice == 3){
                check = false;
                System.out.println("Exiting Portal.");
            } else {
                System.out.println("Invalid Option!");
            }

//            System.out.println("[1] Save Student");
//            System.out.println("[2] Display Student");
//            System.out.println("[3] Update Student");
//            System.out.println("[4] Remove Student");
//            System.out.println("[5] Exit");
//
//            System.out.print("Enter your choice: ");
//            int choice = input.nextInt();
//            input.nextLine();
//
//            switch (choice){
//                case 1: //add
//                    System.out.print("Enter Student Name: ");
//                    String name = input.nextLine();
//
//                    System.out.print("Enter Student ID: ");
//                    String ID = input.nextLine();
//
//                    System.out.print("Enter Student program: ");
//                    String prog = input.nextLine();
//
//                    registrar.saveStudent(new Student(name, ID, prog));
//                    registrar.displayAllStudent();
//                    break;
//
//                case 2: //display
//                    System.out.println("\nHere's the student list.");
//                    registrar.displayAllStudent();
//                    break;
//
//                case 3: // update
//                    System.out.print("Enter the Student ID you want to update: ");
//                    String upt = input.nextLine();
//
//
//
//                    System.out.print("Enter the Student Name you want to update: ");
//                    name = input.nextLine();
//
//                    System.out.print("Enter the Student Program you want to update: ");
//                    prog = input.nextLine();
//
//
//                    if (registrar.updateStudent(new Student(name, upt, prog))) {
//                        System.out.println("Student updated successfully!");
//                    } else {
//                        System.out.println("Error: Student ID " + upt + " not found.");
//                    }
//
//                    break;
//
//                case 4: //remove
//
//                    break;
//
//
//                case 5: //exit
//
//                    check = false;
//                    break;
//            }
//        }





    }
}
}