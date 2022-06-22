/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Campus;
import DTO.CampusList;
import DTO.CourseList;
import DTO.RegistrationList;
import DTO.Student;
import DTO.StudentList;
import UI.Menu;
import util.Validation;

/**
 *
 * @author PC
 */
public class StudentFPTUManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("FPTU Management System");
        menu.addNewOption("1. Manage campus list");
        menu.addNewOption("2. Manage student list");
        menu.addNewOption("3. Manage course list");
        menu.addNewOption("4. Update campus information for students");
        menu.addNewOption("5. Manage students enroll course");
        menu.addNewOption("6. Quit");

        CampusList pList = new CampusList();
        StudentList sList = new StudentList();
        CourseList cList = new CourseList();
        RegistrationList rList = new RegistrationList(sList, cList);

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to manage campus list");
                    manageCampusList(pList);
                    break;
                case 2:
                    System.out.println("You are required to manage student list");
                    manageStudentList(sList);
                    break;
                case 3:
                    System.out.println("You are required to manage course list");
                    manageCourseList(cList);
                    break;
                case 4:
                    System.out.println("You are required to update campus information for students");
                    updateCampusForStudent(pList, sList);
                    break;
                case 5:
                    System.out.println("You are required to manage students enroll course");
                    manageStudentEnrollCourse(rList, sList, cList);
                    break;
                case 6:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageCampusList(CampusList list) {
        Menu menuPet = new Menu("Campus List Management");
        menuPet.addNewOption("1. Add a new campus information");
        menuPet.addNewOption("2. Search a campus information by id");
        menuPet.addNewOption("3. Update a campus information by id");
        menuPet.addNewOption("4. Remove a campus information by id");
        menuPet.addNewOption("5. Print the campus list ascending by code");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new campus information");
                    list.addCampus();
                    break;
                case 2:
                    System.out.println("You are required to search a campus information by id");
                    list.searchCampus();
                    break;
                case 3:
                    System.out.println("You are required to update a campus information by id");
                    list.updateCampus();
                    break;
                case 4:
                    System.out.println("You are required to remove a campus information by id");
                    list.removeCampus();
                    break;
                case 5:
                    System.out.println("You are required to print the campus list ascending by code");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageStudentList(StudentList list) {
        Menu menuPet = new Menu("Student List Management");
        menuPet.addNewOption("1. Add a new student profile");
        menuPet.addNewOption("2. Search a student profile by id");
        menuPet.addNewOption("3. Update a student profile by id");
        menuPet.addNewOption("4. Remove a student profile by id");
        menuPet.addNewOption("5. Print the student list ascending by id");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new student profile");
                    list.addStudent();
                    break;
                case 2:
                    System.out.println("You are required to search a student profile by id");
                    list.searchStudent();
                    break;
                case 3:
                    System.out.println("You are required to update a student profile by id");
                    list.updateStudent();
                    break;
                case 4:
                    System.out.println("You are required to remove a student profile by id");
                    list.removeStudent();
                    break;
                case 5:
                    System.out.println("You are required to print the student list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageCourseList(CourseList list) {
        Menu menuPet = new Menu("Course List Management");
        menuPet.addNewOption("1. Add a new course infomation");
        menuPet.addNewOption("2. Search a course infomation by id");
        menuPet.addNewOption("3. Update a course infomation by id");
        menuPet.addNewOption("4. Remove a course infomation by id");
        menuPet.addNewOption("5. Print the course list ascending by id");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new course infomation");
                    list.addCourse();
                    break;
                case 2:
                    System.out.println("You are required to search a course infomation by id");
                    list.searchCourse();
                    break;
                case 3:
                    System.out.println("You are required to update a course infomation by id");
                    list.updateCourse();
                    break;
                case 4:
                    System.out.println("You are required to remove a course infomation by id");
                    list.removeCourse();
                    break;
                case 5:
                    System.out.println("You are required to print the course list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void updateCampusForStudent(CampusList cList, StudentList sList) {
        if (cList.isEmpty() || sList.isEmpty()) {
            if (cList.isEmpty()) {
                System.out.println("The list of campus is empty. Please add a new campus!");
            }
            if (sList.isEmpty()) {
                System.out.println("The list of student is empty. Please add a new student!");
            }
            return;
        }

        String id, code;
        Campus c;
        Student s;
        String choice = "";

        Menu menu = new Menu("Update campus information for students");
        menu.addNewOption("1. Update");
        menu.addNewOption("2. Print a list of students by campus");
        menu.addNewOption("3. Quit");
        int input;

        do {
            menu.printMenu();
            input = menu.getChoice();
            switch (input) {
                case 1:
                    do {
                        code = Validation.getID("Input campus's code (CXX): ", "The format of id is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
                        c = cList.searchCampusReturnObj(code);
                        if (c == null) {
                            System.out.println("Not found this campus in campus list. Please input campus's code again!");
                        } else {
                            System.out.println("Here is the campus have code: " + code);
                            String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
                            System.out.println(header);
                            c.output();

                            do {
                                id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
                                s = sList.searchStudentReturnObj(id);
                                if (s == null) {
                                    System.out.println("Not found this student in student list. Please input student's id again!");
                                } else {
                                    System.out.println("Here is the student have ID: " + id);
                                    header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
                                    System.out.println(header);
                                    s.output();

                                    if (s.checkCampus() != null) {
                                        choice = Validation.getTwoOption("\nThis student already has a campus, are you sure you still want to update the campus for student? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                    } else {
                                        choice = Validation.getTwoOption("Are you sure you want to update the campus " + code + " for student " + id + "? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                    }
                                    switch (choice) {
                                        case "y":
                                            s.setCampus(c);
                                            System.out.println("After update, here is the student have ID: " + id);
                                            System.out.println(header);
                                            s.output();
                                            break;
                                        case "n":
                                            break;
                                    }
                                    System.out.println("");
                                    choice = Validation.getTwoOption("Do you want to update this campus information for another student? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                }
                            } while (s == null || choice.equalsIgnoreCase("y"));
                            choice = Validation.getTwoOption("Do you want to continue updating campus information for student? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        }
                    } while (c == null || choice.equalsIgnoreCase("y"));
                    break;
                case 2:
                    Campus x;
                    code = Validation.getID("Input campus's code (CXX): ", "The format of id is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
                    x = cList.searchCampusReturnObj(code);
                    System.out.println("------------------------------------");
                    if (x == null) {
                        System.out.println("Not found!!!");
                    } else {
                        System.out.println("CAMPUS");
                        String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
                        System.out.println(header);
                        x.output();

                        System.out.println("------------------------------------");
                        System.out.println("Student list belongs to campus " + code);
                        header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
                        System.out.println(header);
                        sList.printListStudentByCampus(code);
                    }
                    break;
                case 3:
                    break;
            }
        } while (input != 3);

    }

    public static void manageStudentEnrollCourse(RegistrationList list, StudentList sList, CourseList cList) {
        if (sList.isEmpty() || cList.isEmpty()) {
            if (sList.isEmpty()) {
                System.out.println("The list of student is empty. Please add a new student!");
            }
            if (cList.isEmpty()) {
                System.out.println("The list of course is empty. Please add a new course!");
            }
            return;
        }
        
        Menu menuPet = new Menu("Registration List Management");
        menuPet.addNewOption("1. Add a new registration");
        menuPet.addNewOption("2. Search registration by student's id");
        menuPet.addNewOption("3. Remove a registration by student's id");
        menuPet.addNewOption("4. Print the registration list");
        menuPet.addNewOption("5. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new registration");
                    list.addRegistration();
                    break;
                case 2:
                    System.out.println("You are required to search registration by student's id");
                    list.searchRegistrationByStudentID();
                    break;
                case 3:
                    System.out.println("You are required to remove a registration by student's id");
                    list.removeAregistration();
                    break;
                case 4:
                    System.out.println("You are required to print the registration list");
                    list.displayAll();
                    break;
                case 5:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 5);
    }

}
