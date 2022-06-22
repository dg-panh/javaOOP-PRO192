/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import UI.Menu;
import java.util.ArrayList;
import java.util.Collections;
import util.Validation;

/**
 *
 * @author PC
 */
public class StaffList {

    ArrayList<Staff> list;

    public StaffList() {
        list = new ArrayList<>();
    }

    public void addStaff() {
        String id, name, gender;
        double basicSalary;
        int pos;
        do {
            id = Validation.getID("Input manager's id (SXXXXX): ", "The format of id is SXXXXX (X stands for a digit)", "^[S|s]\\d{5}$");
            pos = searchStaffReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input staff's name: ", "Name mustn't empty or contains all whitespace characters. Please input staff's name again!", 1, 15).toUpperCase();
        gender = Validation.getTwoOption("Input staff's gender (male/female): ", "Gender must be male or female. Please input staff's gender again!", "male", "female");
        basicSalary = Validation.getADouble("Input basic salary: ", "Salary must be from 1 to 999999.9. Please input basic salary again!", 1, 999999.9);
        list.add(new Staff(id, name, gender, basicSalary));
        System.out.println("A staff profile is added successfully!");
    }

    public void addManager() {
        String id, name, gender;
        double basicSalary, bonusSalary;
        int pos;
        do {
            id = Validation.getID("Input manager's id (MXXXXX): ", "The format of id is MXXXXX (X stands for a digit)", "^[M|m]\\d{5}$");
            pos = searchStaffReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input manager's name: ", "Name mustn't empty or contains all whitespace characters. Please input manager's name again!", 1, 15).toUpperCase();
        gender = Validation.getTwoOption("Input manager's gender (male/female): ", "Gender must be male or female. Please input manager's gender again!", "male", "female");
        basicSalary = Validation.getADouble("Input basic salary: ", "Salary must be from 1 to 999999.9. Please input basic salary again!", 1, 999999.9);
        bonusSalary = Validation.getADouble("Input bonus salary: ", "Salary must be from 1 to 999999.9. Please input bonus salary again!", 1, 999999.9);
        list.add(new Manager(id, name, gender, basicSalary, bonusSalary));
        System.out.println("A manager profile is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the staff and manager list");
        String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }

    public void searchStaffOrManager() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Please add a new staff/manager!");
            return;
        }

        String id;
        Staff x;

        id = Validation.getString("Input id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        x = searchStaffReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the staff/manager that you want to search");
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            x.output();
        }
    }

    public int searchStaffReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Staff searchStaffReturnObj(String id) {
        for (Staff staff : list) {
            if (staff.getId().equalsIgnoreCase(id)) {
                return staff;
            }
        }
        return null;
    }

    public void updateStaffOrManager() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Please add a new staff/manager!");
            return;
        }

        String id, newName, newGender;
        double newBaSalary;
        double newBoSalary;
        Staff x;
        id = Validation.getString("Input id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        x = searchStaffReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the staff/manager before updating");
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Staff/Manager Update");
            updateMenu.addNewOption("1. Update name");
            updateMenu.addNewOption("2. Update gender");
            updateMenu.addNewOption("3. Update basic salary");
            updateMenu.addNewOption("4. Update bonus salary");
            updateMenu.addNewOption("5. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input staff's name: ", "Name mustn't empty or contains all whitespace characters. Please input staff's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The staff's name is updated successfully! Here is the staff after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new gender");
                        newGender = Validation.getTwoOption("Input staff's gender (male/female): ", "Gender must be male or female. Please input staff's gender again!", "male", "female");
                        x.setGender(newGender);
                        System.out.println("The staff's gender is updated successfully! Here is the staff after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new basic salary");
                        newBaSalary = Validation.getADouble("Input basic salary: ", "Salary must be from 1 to 999999.9. Please input basic salary again!", 1, 999999.9);
                        x.setBasicSalary(newBaSalary);
                        System.out.println("The staff's basic salary is updated successfully! Here is the staff after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        if (x instanceof Manager) {
                            System.out.println("You are required to input a new bonus salary");
                            newBoSalary = Validation.getADouble("Input bonus salary: ", "Salary must be from 1 to 999999.9. Please input bonus salary again!", 1, 999999.9);
                            ((Manager) x).setBonusSalary(newBoSalary);
                            System.out.println("The manager's bonus salary is updated successfully! Here is the manager after updating");
                            System.out.println(header);
                            x.output();
                        } else {
                            System.out.println("Staff don't have bonus salary. Unable to update!");
                        }
                        break;

                    case 5:
                        break;
                }
            } while (choice != 5);
        }
    }

    public void removeStaffOrManager() {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Please add a new staff/manager!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getString("Input id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        pos = searchStaffReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this staff/manager? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected staff/manager is removed successfully!");
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ArrayList<Manager> getManagerList() {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList<Manager> mList = new ArrayList<>();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Manager) {
                mList.add((Manager) list.get(i));
            }
        }
        return mList;
    }

    public void searchByManagerId() {
        String id;
        Staff x;
        int count = 0;

        id = Validation.getID("Input manager's id (MXXXXX): ", "The format of id is MXXXXX (X stands for a digit)", "^[M|m]\\d{5}$");
        x = searchStaffReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("MANAGER");
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            x.output();

            System.out.println("------------------------------------");
            System.out.println("The employees under the management of manager " + id);
            System.out.println(header);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getManager() != null) {
                    if (list.get(i).getManager().id.equalsIgnoreCase(id)) {
                        list.get(i).output();
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println("None");
            }
        }
    }

    public void printStaffWithoutManager() {
        System.out.println("Here is the list of employees without a manager");
        String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
        System.out.println(header);
        for (Staff staff : list) {
            if (staff.getManager() == null) {
                staff.output();
            }
        }
    }

}
