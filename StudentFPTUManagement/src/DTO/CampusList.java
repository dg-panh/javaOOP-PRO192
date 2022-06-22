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
public class CampusList {
    ArrayList<Campus> list;
    
    public CampusList() {
        list = new ArrayList<>();
    }
    
    public void addCampus() {
        String code, name, address;
        int pos;
        do {
            code = Validation.getID("Input campus's code (CXX): ", "The format of code is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
            pos = searchCampusReturnPos(code);
            if (pos != -1) {
                System.out.println("The code already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input campus's name: ", "Name mustn't empty or contains all whitespace characters. Please input campus's name again!", 1, 15).toUpperCase();
        address = Validation.getString("Input campus's address: ", "Address mustn't empty or contains all whitespace characters. Please input campus's address again!", 1, 20);       
        list.add(new Campus(code, name, address));
        System.out.println("A campus information is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list of campus is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the campus list");
        String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }
    
    public void searchCampus() {
        if (list.isEmpty()) {
            System.out.println("The list of campus is empty. Please add a new campus!");
            return;
        }
        
        String code;
        Campus x;  
        
        code = Validation.getID("Input campus's code (CXX): ", "The format of id is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
        x = searchCampusReturnObj(code);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the campus that you want to search");
            String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchCampusReturnPos(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code))
                return i;
        }
        return -1;
    }
    
    public Campus searchCampusReturnObj(String code) {
        for (Campus o : list) {
            if (o.getCode().equalsIgnoreCase(code))
                return o;
        }
        return null;
    }
    
    public void updateCampus() {
        if (list.isEmpty()) {
            System.out.println("The list of campus is empty. Please add a new campus!");
            return;
        }
        
        String code, newName, newAddress;
        Campus x;
        code = Validation.getID("Input campus's code (CXX): ", "The format of id is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
        x = searchCampusReturnObj(code);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the campus before updating");
            String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Campus Update");
            updateMenu.addNewOption("1. Update campus's name");
            updateMenu.addNewOption("2. Update campus's address");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input campus's name: ", "Name mustn't empty or contains all whitespace characters. Please input campus's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The campus's name is updated successfully! Here is the campus after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new address");
                        newAddress = Validation.getString("Input campus's address: ", "Address mustn't empty or contains all whitespace characters. Please input campus's address again!", 1, 20);
                        x.setAddress(newAddress);
                        System.out.println("The campus's address is updated successfully! Here is the campus after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }
    
    public void removeCampus() {
        if (list.isEmpty()) {
            System.out.println("The list of campus is empty. Please add a new campus!");
            return;
        }
        
        String code, choice;
        int pos;
        code = Validation.getID("Input campus's code (CXX): ", "The format of id is CXX (X stands for a digit)", "^[C|c]\\d{2}$");
        pos = searchCampusReturnPos(code);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-4s|%-15s|%20s|", "CODE", "NAME", "ADDRESS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this campus? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected campus is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
