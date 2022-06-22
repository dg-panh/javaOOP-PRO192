/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Manager;
import DTO.ManagerList;
import DTO.Staff;
import DTO.StaffList;
import DTO.TaskList;
import DTO.TimeSheetList;
import UI.Menu;
import java.util.ArrayList;
import util.Validation;

/**
 *
 * @author PC
 */
public class StaffManagement {

    public static void main(String[] args) {
        Menu menu = new Menu("Staff Management System");
        menu.addNewOption("1. Manage staff/manager list");
        menu.addNewOption("2. Manage task list");
        menu.addNewOption("3. Update manager information for staff");
        menu.addNewOption("4. Manage tasks performed by staffs");
        menu.addNewOption("5. Quit");

        StaffList sList = new StaffList();
        TaskList tList = new TaskList();
        TimeSheetList tsList = new TimeSheetList(sList, tList);

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to manage staff/manager list");
                    manageStaffList(sList);
                    break;
                case 2:
                    System.out.println("You are required to manage task list");
                    manageTaskList(tList);
                    break;
                case 3:
                    System.out.println("You are required to update manager information for staff");
                    updateManagerForStaff(sList);
                    break;
                case 4:
                    System.out.println("You are required to manage tasks performed by staffs");
                    manageTimeSheetList(tsList, sList, tList);
                    break;
                case 5:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 5);
    }

    public static void manageStaffList(StaffList list) {
        Menu menu = new Menu("Staff/Manager List Management");
        menu.addNewOption("1. Add a new staff profile");
        menu.addNewOption("2. Add a new manager profile");
        menu.addNewOption("3. Search a staff/manager profile by id");
        menu.addNewOption("4. Update a staff/manager profile by id");
        menu.addNewOption("5. Remove a staff/manager profile by id");
        menu.addNewOption("6. Print all list ascending by id");
        menu.addNewOption("7. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new staff profile");
                    list.addStaff();
                    break;
                case 2:
                    System.out.println("You are required to add a new manager profile");
                    list.addManager();
                    break;
                case 3:
                    System.out.println("You are required to search a staff/manager profile by id");
                    list.searchStaffOrManager();
                    break;
                case 4:
                    System.out.println("You are required to update a staff/manager profile by id");
                    list.updateStaffOrManager();
                    break;
                case 5:
                    System.out.println("You are required to remove a staff/manager profile by id");
                    list.removeStaffOrManager();
                    break;
                case 6:
                    System.out.println("You are required to print all list ascending by id");
                    list.displayAll();
                    break;
                case 7:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 7);
    }

    public static void manageManagerList(ManagerList list) {
        Menu menu = new Menu("Manager List Management");
        menu.addNewOption("1. Add a new manager profile");
        menu.addNewOption("2. Search a manager profile by id");
        menu.addNewOption("3. Update a manager profile by id");
        menu.addNewOption("4. Remove a manager profile by id");
        menu.addNewOption("5. Print the manager list ascending by id");
        menu.addNewOption("6. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new manager profile");
                    list.addManager();
                    break;
                case 2:
                    System.out.println("You are required to search a manager profile by id");
                    list.searchManager();
                    break;
                case 3:
                    System.out.println("You are required to update a manager profile by id");
                    list.updateManager();
                    break;
                case 4:
                    System.out.println("You are required to remove a manager profile by id");
                    list.removeManager();
                    break;
                case 5:
                    System.out.println("You are required to print the manager list ascending by id");
                    list.displayAllManager();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageTaskList(TaskList list) {
        Menu menu = new Menu("Task List Management");
        menu.addNewOption("1. Add a new task information");
        menu.addNewOption("2. Search a task by id");
        menu.addNewOption("3. Update a task by id");
        menu.addNewOption("4. Remove a task by id");
        menu.addNewOption("5. Print the task list ascending by id");
        menu.addNewOption("6. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new task information");
                    list.addTask();
                    break;
                case 2:
                    System.out.println("You are required to search a task by id");
                    list.searchTask();
                    break;
                case 3:
                    System.out.println("You are required to update a task by id");
                    list.updateTask();
                    break;
                case 4:
                    System.out.println("You are required to remove a task by id");
                    list.removeTask();
                    break;
                case 5:
                    System.out.println("You are required to print the task list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void updateManagerForStaff(StaffList list) {
        if (list.isEmpty()) {
            System.out.println("The list of staff is empty. Please add a new staff!");
            return;
        }

        String sId, mId;
        Staff m;
        Staff s;
        String choice = "";

        Menu menu = new Menu("Update manager information for staff");
        menu.addNewOption("1. Update");
        menu.addNewOption("2. Search by manager's id");
        menu.addNewOption("3. List of staffs without a manager");
        menu.addNewOption("4. Quit");
        int input;
        do {
            menu.printMenu();
            input = menu.getChoice();
            switch (input) {
                case 1:
                    do {
                        mId = Validation.getID("Input manager's id (MXXXXX): ", "The format of id is MXXXXX (X stands for a digit)", "^[M|m]\\d{5}$");
                        m = list.searchStaffReturnObj(mId);
                        if (m == null) {
                            System.out.println("Not found this manager in list. Please input manager's id again!");
                        } else {
                            System.out.println("Here is the manager have ID: " + mId);
                            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
                            System.out.println(header);
                            m.output();

                            do {
                                sId = Validation.getString("Input staff's/manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
                                s = list.searchStaffReturnObj(sId);
                                if (s == null) {
                                    System.out.println("Not found this staff/manager in list. Please input id again!");
                                } else if (sId.equalsIgnoreCase(mId)){
                                    System.out.println("These two are one. Unable update manager information for staff!");
                                } else {
                                    System.out.println("Here is the staff/manager have ID: " + sId);
                                    header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
                                    System.out.println(header);
                                    s.output();

                                    if (s.getManager() != null) {
                                        choice = Validation.getTwoOption("\nThis staff/manager already has a manager, are you sure you still want to update the manager for his/her? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                    } else {
                                        if (m.getManager() == null) {
                                            choice = Validation.getTwoOption("Are you sure you want to update the manager " + mId + " for staff " + sId + "? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                        } else {
                                            if (m.getManager().getId().equalsIgnoreCase(sId)) {
                                                String msg = "\nThis manager " + sId + " is the manager of the manager " + mId + ", are you sure you still want to update the manager for his/her? (y/n): ";
                                                choice = Validation.getTwoOption(msg, "Your choice must be y or n. Please input your choice again!", "y", "n");
                                            }
                                        }
                                    }
                                    switch (choice) {
                                        case "y":
                                            if (m.getManager() != null) {
                                                if (m.getManager().getId().equalsIgnoreCase(sId)) {
                                                    m.setManager(null);
                                                }
                                            }
                                            s.setManager((Manager) m);
                                            System.out.println("Updated!");
                                            break;
                                        case "n":
                                            break;
                                    }
                                    System.out.println("");
                                    choice = Validation.getTwoOption("Do you want to update THIS manager information with another staff? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                }
                            } while (s == null || choice.equalsIgnoreCase("y"));
                            choice = Validation.getTwoOption("Do you want to continue updating manager information for staff? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        }
                    } while (m == null || choice.equalsIgnoreCase("y"));
                    break;
                case 2:
                    list.searchByManagerId();
                    break;
                case 3:
                    list.printStaffWithoutManager();
                    break;
                case 4:
                    break;
            }
        } while (input != 4);

    }

    public static void manageTimeSheetList(TimeSheetList list, StaffList sList, TaskList tList) {
        if (sList.isEmpty() || tList.isEmpty()) {
            if (sList.isEmpty()) {
                System.out.println("The list of staff/manager is empty. Please add a new staff/manager!");
            }
            if (tList.isEmpty()) {
                System.out.println("The list of task is empty. Please add a new task!");
            }
            return;
        }
        
        Menu menuPet = new Menu("Timesheet List Management");
        menuPet.addNewOption("1. Add a new timesheet");
        menuPet.addNewOption("2. Search timesheets by staff's/manager's id");
        menuPet.addNewOption("3. Remove a timesheet by staff's/manager's id");
        menuPet.addNewOption("4. Print the timesheet list");
        menuPet.addNewOption("5. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new timesheet");
                    list.addTimesheet();
                    break;
                case 2:
                    System.out.println("You are required to search timesheets by staff's/manager's id");
                    list.searchTimesheetByStaffID();
                    break;
                case 3:
                    System.out.println("You are required to remove a timesheet by staff's/manager's id");
                    list.removeATimesheet();
                    break;
                case 4:
                    System.out.println("You are required to print the timesheet list");
                    list.displayAll();
                    break;
                case 5:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 5);
    }
}
