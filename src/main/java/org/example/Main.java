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
        TuitionRegistration TR = new TuitionRegistration();
        IEnrollmentService ES = new EnrollmentServiceImpl();

        //controllers
        Registrar registrar = new Registrar(SR, CR, DR, SRS, TR, ES);
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
                            "[6] Enroll Student in Section\n[7] Check Balance\n[8] Make Payment\n[9] Display Hierarchy"
                            + "\n[10] Create Department\n[11] Back to Main");
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

                            System.out.print("Enter Max Capacity: ");
                            int cap = input.nextInt();
                            input.nextLine();

                            Section s = new Section(newSection, cap, null, new ArrayList<>());

                            System.out.println("\n--- Available Courses ---");
                            registrar.displayAll(); // calls courseReg.displayAll()
                            System.out.print("Enter Course ID to assign to this section: ");
                            String cID = input.nextLine();
                            Course foundC = CR.findByID(cID);

                            if (foundC != null) {
                                s.setCourse(foundC);
                                System.out.println("Section linked to Course: " + foundC.getCourseName());
                            } else {
                                System.out.println("Course not found. Section created without a linked course.");
                            }

                            registrar.saveSection(s);

                            System.out.println("\n--- Available Departments ---");
                            for (Department dpt : DR.displayAll()) {
                                System.out.println("- " + dpt.getDepartmentName());
                            }

                            System.out.print("Enter Department Name to link this section to: ");
                            String linkDept = input.nextLine();

                            List<Department> allDepts = DR.displayAll();
                            Department d = null;

                            for (Department dept : allDepts) {
                                if (dept.getDepartmentName().equalsIgnoreCase(linkDept)) {
                                    d = dept;
                                    break;
                                }
                            }

                            if (d != null) {
                                d.getSectionList().add(s);
                                System.out.println("Section " + newSection + " successfully linked to " + linkDept + "!");
                            } else {
                                System.out.println("Department not found. Section created but remains unassigned to a hierarchy.");
                            }
                            break;
                        case 6:
                            System.out.print("Enter Section Name for Enrollment: ");
                            String secName = input.nextLine();
                            Section foundSec = SRS.findBySectionName(secName);

                            if (foundSec == null) {
                                System.out.println("Section " + secName + " not found!");
                                System.out.print("Would you like to create one now? (y/n): ");
                                String ans = input.nextLine();

                                if (ans.equalsIgnoreCase("y")) {
                                    System.out.print("Enter Max Capacity for " + secName + ": ");
                                    int cap2 = input.nextInt();
                                    input.nextLine();
                                    registrar.saveSection(new Section(secName, cap2, null, new ArrayList<>()));
                                    System.out.println("Section successfully created! Please enroll again!");
                                }
                            } else {
                                if (foundSec.getStudentList().size() >= foundSec.getMaxCapacity()) {
                                    System.out.println("CRITICAL ERROR: " + secName + " is already FULL (Capacity: " + foundSec.getMaxCapacity() + ")");
                                    break;
                                }

                                boolean enrollDone = false;
                                while (!enrollDone) {
                                    System.out.print("\nEnter Student ID to enroll: ");
                                    String sID = input.nextLine();
                                    Student record = SR.findByID(sID);

                                    if (record == null) {
                                        System.out.println("Student ID " + sID + " is not registered in the system!");
                                        System.out.print("Try a different ID? (y/n): ");
                                        if (input.nextLine().equalsIgnoreCase("n")) {
                                            break;
                                        }
                                        continue;
                                    }

                                    System.out.print("Enter Student Name: ");
                                    String sName = input.nextLine();
                                    if (!sName.equalsIgnoreCase(record.getPersonName())) {
                                        System.out.println("Name does not match the records. Please check typos.");
                                        continue;
                                    }

                                    System.out.print("Enter Student Program: ");
                                    String sProg = input.nextLine();
                                    if (!sProg.equalsIgnoreCase(record.getProgram())) {
                                        System.out.println("Program does not match the records. Please check typos.");
                                        continue;
                                    }

                                    // tuition logic
                                    int finalUnits;
                                    if (foundSec.getCourse() != null) {
                                        finalUnits = foundSec.getCourse().getUnits();
                                        System.out.println("Course Detected: " + foundSec.getCourse().getCourseName());
                                        System.out.println("Automatic Units: " + finalUnits);
                                    } else {
                                        System.out.println("Warning: No Course linked to this section.");
                                        System.out.print("Enter units manually: ");
                                        finalUnits = input.nextInt();
                                        input.nextLine();
                                    }

                                    registrar.calculateAndSetTuition(record, finalUnits);
                                    registrar.enrollStudent(foundSec, record);
                                    enrollDone = true;
                                }
                            }
                            break;
                        case 7:
                            System.out.print("Enter Student ID to check balance: ");
                            String checkID = input.nextLine();
                            registrar.checkStudentBalance(checkID);
                            break;
                        case 8:
                            System.out.print("Enter Student ID: ");
                            String payID = input.nextLine();
                            System.out.print("Enter payment amount: ");
                            double amount = input.nextDouble();
                            input.nextLine();
                            registrar.processStudentPayment(payID, amount);
                            break;
                        case 9:
                            registrar.displayHierarchy();
                            break;
                        case 10:
                            System.out.print("Enter Department ID: ");
                            String dID = input.nextLine();
                            System.out.print("Enter Department Name: ");
                            String dName = input.nextLine();

                            // new department with empty lists for sections & instructors
                            Department newDept = new Department(dID, dName, new ArrayList<>(), new ArrayList<>());
                            registrar.saveDept(newDept);
                            System.out.println("Department " + dName + " created successfully!");
                            break;
                        case 11:
                            regLoop = false;
                            break;



                    }

                }

            } else if (pChoice == 2){
                boolean hrLoop = true;
                while (hrLoop){
                    System.out.println("\n===WELCOME TO THE HR PORTAL===");
                    System.out.println("[1] Hire Instructors\n[2] Display All Intructors\n[3] Update Instructor\n[4] " +
                                    "Remove Instructor\n[5] Assign Instructor to Section\n[6] Back to Main");
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
                                hr.updateInstructorDeets(upID, new Instructor(un, upID, uc));
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
                            System.out.println("\n--- Assign Instructor to Section ---");

                            // 1. Get and show instructors
                            List<Instructor> insList = IR.displayAll();
                            if (insList.isEmpty()) break;

                            System.out.print("Enter Instructor ID: ");
                            String targetID = input.nextLine();
                            Instructor selectedIns = IR.findByID(targetID);

                            if (selectedIns == null) {
                                System.out.println("Instructor not found!");
                                break;
                            }

                            List<Section> secList = SRS.displayAll();
                            if (secList.isEmpty()) {
                                System.out.println("No sections available to assign to.");
                                break;
                            }

                            System.out.print("Enter Section Name: ");
                            String targetSec = input.nextLine();
                            Section selectedSec = SRS.findBySectionName(targetSec);

                            if (selectedSec == null) {
                                System.out.println("Section not found!");
                                break;
                            }

                            IR.assignInstructorToSection(selectedIns, selectedSec);
                            break;
                        case 6:
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