package org.example;
import org.example.model.*;
import org.example.service.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

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
            try {

                System.out.println("\n========================");
                System.out.println("      CAMPUS PORTAL      ");
                System.out.println("========================");
                System.out.println("[1] Registrar (Student/Section/Department Registrations");
                System.out.println("[2] HR (Instructor Registration)");
                System.out.println("[3] Exit portal");
                System.out.print("Select Portal: ");

                int pChoice = input.nextInt();
                input.nextLine();

                if (pChoice == 1) {
                    boolean regLoop = true;
                    while (regLoop) {
                        System.out.println("\n===WELCOME TO THE REGISTRAR PORTAL===");
                        System.out.println("[1] Save Student\n[2] Display All Students\n[3] Update Student\n[4] Remove" +
                                "Student\n[5] Create Section\n" +
                                "[6] Enroll Student in Section\n[7] Check Balance\n[8] Make Payment\n[9] Display Hierarchy"
                                + "\n[10] Create Department\n[11] Create Course\n[12] Update Course\n[13] Remove Course\n" +
                                "[14] Display Courses\n[15] Back to Main");
                        System.out.print("Select Option: ");
                        int regOption = input.nextInt();
                        input.nextLine();

                        switch (regOption) {
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

                                Student toUpdateStudent = SR.findByID(uID);

                                if (toUpdateStudent != null) {
                                    System.out.println("Current Student: " + toUpdateStudent.getPersonName());
                                    System.out.print("New Name: ");
                                    String uName = input.nextLine();
                                    System.out.print("New Program: ");
                                    String uProg = input.nextLine();

                                    toUpdateStudent.setPersonName(uName);
                                    toUpdateStudent.setProgram(uProg);

                                    System.out.println("Update Success! " + uID + " is now " + uName);
                                } else {
                                    System.out.println("Student ID " + uID + " not found!");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Student ID to remove: ");
                                String rID = input.nextLine();
                                registrar.removeStudent(rID);
                                break;

                            case 5:
                                System.out.println("\n--- Create New Section ---");
                                System.out.print("New Section Name: ");
                                String newSecName = input.nextLine();
                                System.out.print("Enter Max Capacity: ");
                                int maxCap = input.nextInt();
                                input.nextLine();

                                Instructor selIns = null;
                                Course selCourse = null;
                                Department selDept = null;

                                while (selIns == null) {
                                    IR.displayAll();
                                    System.out.print("Enter Instructor ID: ");
                                    selIns = IR.findByID(input.nextLine());
                                    if (selIns == null) System.out.println("Invalid ID. Try again.");
                                }

                                while (selCourse == null) {
                                    registrar.displayAll();
                                    System.out.print("Enter Course ID: ");
                                    selCourse = CR.findByID(input.nextLine());
                                    if (selCourse == null) System.out.println("Invalid ID. Try again.");
                                }

                                while (selDept == null) {
                                    registrar.displayAllDepts();
                                    System.out.print("Enter Department Name: ");
                                    selDept = registrar.findDeptByName(input.nextLine());
                                    if (selDept == null) System.out.println("Invalid Dept. Try again.");
                                }

                                Section newSec = new Section(newSecName, maxCap, selIns, new ArrayList<>());
                                newSec.setCourse(selCourse);
                                selDept.getSectionList().add(newSec);

                                SRS.save(newSec);

                                System.out.println("Section " + newSecName + " saved and linked successfully!");
                                break;
                            case 6:
                                input.nextLine();
                                System.out.print("Enter Section Name for Enrollment: ");
                                String secName = input.nextLine().trim();
                                Section foundSec = SRS.findBySectionName(secName);

                                if (foundSec == null) {
                                    System.out.println("Section '" + secName + "' not found!");
                                    System.out.println("Please use Option [5] to create a properly linked Section first.");
                                } else {
                                    if (foundSec.getStudentList().size() >= foundSec.getMaxCapacity()) {
                                        System.out.println("CRITICAL ERROR: " + secName + " is already FULL (Capacity: " + foundSec.getMaxCapacity() + ")");
                                        break;
                                    }

                                    boolean enrollDone = false;
                                    while (!enrollDone) {
                                        System.out.print("\nEnter Student ID to enroll: ");
                                        String sID = input.nextLine().trim();
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
                                        String sName = input.nextLine().trim();
                                        if (!sName.equalsIgnoreCase(record.getPersonName())) {
                                            System.out.println("Name does not match the records. Please check typos.");
                                            continue;
                                        }

                                        System.out.print("Enter Student Program: ");
                                        String sProg = input.nextLine().trim();
                                        if (!sProg.equalsIgnoreCase(record.getProgram())) {
                                            System.out.println("Program does not match the records. Please check typos.");
                                            continue;
                                        }

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
                                String dName = "";
                                boolean nameIsUnique = false;

                                while (!nameIsUnique) {
                                    System.out.print("Enter Department Name: ");
                                    dName = input.nextLine().trim();

                                    if (dName.isEmpty()) continue;

                                    if (registrar.findDeptByName(dName) != null) {
                                        System.out.println("[!] Error: Department '" + dName + "' already exists. Please use a unique name.");
                                    } else {
                                        nameIsUnique = true;
                                    }
                                }

                                System.out.print("Enter Department ID: ");
                                String dID = input.nextLine();

                                Department newDept = new Department(dID, dName, new ArrayList<>(), new ArrayList<>());

                                registrar.saveDept(newDept);

                                System.out.println("Department " + dName + " created successfully!");
                                break;
                            case 11:
                                System.out.println("\n--- Create New Course ---");
                                System.out.print("Enter Course ID: ");
                                String newCID = input.nextLine();

                                if (CR.findByID(newCID) != null) {
                                    System.out.println("[!] ERROR: Course ID '" + newCID + "' already exists in the system!");
                                    System.out.println("Registration cancelled.");
                                    break;
                                }

                                System.out.print("Enter Course Name: ");
                                String newCName = input.nextLine();
                                System.out.print("Enter Program: ");
                                String newCProg = input.nextLine();
                                System.out.print("Enter Units: ");
                                int newCUnits = input.nextInt();
                                input.nextLine();

                                Course courseObj = new Course(newCID, newCName, newCProg, newCUnits);
                                CR.save(courseObj);
                                System.out.println("System: Course " + newCID + " saved successfully.");
                                break;
                            case 12:
                                System.out.println("\n--- Update Existing Course ---");
                                System.out.print("Enter Course ID to update: ");
                                String upID = input.nextLine();
                                Course toUpdate = CR.findByID(upID);

                                if (toUpdate != null) {
                                    System.out.println("Updating Course: " + toUpdate.getCourseName());
                                    System.out.print("Enter New Name: ");
                                    String upName = input.nextLine();
                                    System.out.print("Enter New Program: ");
                                    String upProg = input.nextLine();
                                    System.out.print("Enter New Units: ");
                                    int upUnits = input.nextInt();
                                    input.nextLine();

                                    toUpdate.setCourseName(upName);
                                    toUpdate.setCourseProgram(upProg);
                                    toUpdate.setUnits(upUnits);

                                    System.out.println("Success: Course details modified in the master record!");
                                } else {
                                    System.out.println("Error: Course ID [" + upID + "] not found!");
                                }
                                break;
                            case 13:
                                System.out.println("\n--- Remove Course ---");
                                System.out.print("Enter Course ID to remove: ");
                                String remID = input.nextLine();
                                CR.removeCourse(remID);
                                break;
                            case 14:
                                System.out.println("\n--- Master Course List ---");
                                registrar.displayAll();
                                break;
                            case 15:
                                regLoop = false;
                                break;

                        }

                    }

                } else if (pChoice == 2) {
                    boolean hrLoop = true;
                    while (hrLoop) {
                        System.out.println("\n===WELCOME TO THE HR PORTAL===");
                        System.out.println("[1] Hire Instructors\n[2] Display All Intructors\n[3] Update Instructor\n[4] " +
                                "Remove Instructor\n[5] Assign Instructor to Section\n[6] Back to Main");
                        System.out.print("Select Option: ");
                        int hrOption = input.nextInt();
                        input.nextLine();

                        switch (hrOption) {

                            case 1:
                                System.out.println("\n=== Hire New Instructor ===");
                                System.out.print("Instructor ID: ");
                                String insID = input.nextLine();


                                if (IR.findByID(insID) != null) {
                                    System.out.println("[!] CRITICAL ERROR: Instructor ID '" + insID + "' is already registered.");
                                    System.out.println("Registration aborted. Please use a unique ID.");
                                    break;
                                }

                                System.out.print("Instructor Name: ");
                                String insName = input.nextLine();

                                String linkedCourseName = "";
                                boolean courseFound = false;
                                boolean cancelled = false;

                                while (!courseFound) {
                                    System.out.println("\n--- Master Course List ---");
                                    registrar.displayAll();

                                    System.out.print("Enter Course ID for this Instructor's Specialization (or type 'cancel'): ");
                                    String targetID = input.nextLine();

                                    if (targetID.equalsIgnoreCase("cancel")) {
                                        System.out.println("Hiring process cancelled by user.");
                                        cancelled = true;
                                        break;
                                    }

                                    Course foundC = CR.findByID(targetID);
                                    if (foundC != null) {
                                        linkedCourseName = foundC.getCourseName();
                                        courseFound = true;
                                    } else {
                                        System.out.println("[!] Error: Course ID '" + targetID + "' does not exist. Please try again.");
                                    }
                                }

                                if (courseFound && !cancelled) {
                                    Instructor newIns = new Instructor(insName, insID, linkedCourseName);
                                    IR.save(newIns);
                                    System.out.println("\nSUCCESS: " + insName + " [" + insID + "] hired for " + linkedCourseName);
                                }
                                break;
                            case 2:
                                System.out.println("\n===Here's the list of Instructors===");
                                hr.displayAllInstructors();
                                break;
                            case 3:
                                System.out.print("Enter Instructor ID to update: ");
                                String upID = input.nextLine();
                                Instructor toUpdate = IR.findByID(upID);

                                if (toUpdate != null) {
                                    System.out.println("Updating: " + toUpdate.getPersonName());

                                    System.out.print("New Name: ");
                                    String newName = input.nextLine();

                                    String newCourseName = "";
                                    while (true) {
                                        System.out.print("New Course (Enter Valid Course ID): ");
                                        String targetCID = input.nextLine();
                                        Course validC = CR.findByID(targetCID);

                                        if (validC != null) {
                                            newCourseName = validC.getCourseName();
                                            break;
                                        }
                                        System.out.println("[!] Error: '" + targetCID + "' is not a valid Course ID.");
                                    }

                                    toUpdate.setPersonName(newName);
                                    toUpdate.setCourses(newCourseName);

                                    System.out.println("System: Instructor " + newName + " updated with course " + newCourseName);
                                } else {
                                    System.out.println("Error: Instructor ID not found.");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Instructor ID to remove: ");
                                String deleteID = input.nextLine();
                                hr.removeInstructor(deleteID);
                                break;
                            case 5:
                                System.out.println("\n--- Assign Instructor to Section ---");

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


                } else if (pChoice == 3) {
                    check = false;
                    System.out.println("Exiting Portal.");
                } else {
                    System.out.println("Invalid Option!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid Option! Enter a valid input.");
                input.nextLine();
            }






    }
}
}