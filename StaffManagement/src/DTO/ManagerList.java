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
public class ManagerList {
    ArrayList<Manager> list;

    public ManagerList() {
        list = new ArrayList<>();
    }
    
    public void addManager() {
        String id, name, gender;
        double basicSalary, bonusSalary;
        int pos;
        do {
            id = Validation.getString("Input manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input manager's id again!", 1, 6).toUpperCase();
            pos = searchManagerReturnPos(id);
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

    public void displayAllManager() {
        if (list.isEmpty()) {
            System.out.println("The manager list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the manager list");
        String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
        System.out.println(header);
        list.forEach(manager -> {
            manager.output();
        });
    }

    public void searchManager() {
        if (list.isEmpty()) {
            System.out.println("The list of manager is empty. Please add a new manager!");
            return;
        }

        String id;
        Manager x;

        id = Validation.getString("Input manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input manager's id again!", 1, 6).toUpperCase();
        x = searchManagerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the manager that you want to search");
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            x.output();
        }
    }

    public int searchManagerReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Manager searchManagerReturnObj(String id) {
        for (Manager manager : list) {
            if (manager.getId().equalsIgnoreCase(id)) {
                return manager;
            }
        }
        return null;
    }

    public void updateManager() {
        if (list.isEmpty()) {
            System.out.println("The list of manager is empty. Please add a new manager!");
            return;
        }

        String id, newName, newGender;
        double newBaSalary, newBoSalary;
        Manager x;
        id = Validation.getString("Input manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input manager's id again!", 1, 6).toUpperCase();
        x = searchManagerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the manager before updating");
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Manager Update");
            updateMenu.addNewOption("1. Update manager's name");
            updateMenu.addNewOption("2. Update manager's gender");
            updateMenu.addNewOption("3. Update manager's basic salary");
            updateMenu.addNewOption("4. Update manager's bonus salary");
            updateMenu.addNewOption("5. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input manager's name: ", "Name mustn't empty or contains all whitespace characters. Please input manager's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The manager's name is updated successfully! Here is the manager after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new gender");
                        newGender = Validation.getTwoOption("Input manager's gender (male/female): ", "Gender must be male or female. Please input manager's gender again!", "male", "female");
                        x.setGender(newGender);
                        System.out.println("The manager's gender is updated successfully! Here is the manager after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new basic salary");
                        newBaSalary = Validation.getADouble("Input basic salary: ", "Salary must be from 1 to 999999.9. Please input basic salary again!", 1, 999999.9);
                        x.setBasicSalary(newBaSalary);
                        System.out.println("The manager's basic salary is updated successfully! Here is the manager after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        System.out.println("You are required to input a new bonus salary");
                        newBoSalary = Validation.getADouble("Input bonus salary: ", "Salary must be from 1 to 999999.9. Please input bonus salary again!", 1, 999999.9);
                        x.setBonusSalary(newBoSalary);
                        System.out.println("The manager's bonus salary is updated successfully! Here is the manager after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 5:
                        break;
                }
            } while (choice != 5);
        }
    }

    public void removeManager() {
        if (list.isEmpty()) {
            System.out.println("The list of manager is empty. Please add a new manager!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getString("Input manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input manager's id again!", 1, 6).toUpperCase();
        pos = searchManagerReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%6s|%12s|%12s|", "ID", "NAME", "GENDER", "BASIC SALARY", "BONUS SALARY");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this manager? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected manager is removed successfully!");
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
