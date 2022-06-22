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
public class OwnerList {
    ArrayList<Owner> list;

    public OwnerList() {
        list = new ArrayList<>();
    }
    
    public void addOwner() {
        String id, name, address;
        int pos;
        do {
            id = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
            pos = searchOwnerReturnPos(id);
            if (pos != -1) {
                System.out.println("The owner's id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input owner's name: ", "Owner's name mustn't empty or contains all whitespace characters. Please input owner's name again!", 1, 15).toUpperCase();
        address = Validation.getString("Input owner's address: ", "Owner's address mustn't empty or contains all whitespace characters. Please input owner's address again!", 1, 20);
        list.add(new Owner(id, name, address));
        System.out.println("A owner profile is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The owner list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the owner list");
        String header = String.format("|%-6s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
        System.out.println(header);
        list.forEach(owner -> {
            owner.output();
        });
    }
    
    public void searchOwner() {
        if (list.isEmpty()) {
            System.out.println("The list of owner is empty. Please add a new owner!");
            return;
        }
        
        String id;
        Owner x;  
        
        id = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
        x = searchOwnerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the owner that you want to search");
            String header = String.format("|%-6s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchOwnerReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public Owner searchOwnerReturnObj(String id) {
        for (Owner o : list) {
            if (o.getId().equalsIgnoreCase(id))
                return o;
        }
        return null;
    }
    
    public void updateOwner() {
        if (list.isEmpty()) {
            System.out.println("The list of owner is empty. Please add a new owner!");
            return;
        }
        
        String id, newName, newAddress;
        Owner x;
        id = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
        x = searchOwnerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the Owner before updating");
            String header = String.format("|%-6s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Owner Update");
            updateMenu.addNewOption("1. Update owner's name");
            updateMenu.addNewOption("2. Update owner's address");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input owner's name: ", "Owner's name mustn't empty or contains all whitespace characters. Please input owner's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The owner's name is updated successfully! Here is the owner after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new address");
                        newAddress = Validation.getString("Input owner's address: ", "Owner's address mustn't empty or contains all whitespace characters. Please input owner's address again!", 1, 20);
                        x.setAddress(newAddress);
                        System.out.println("The owner's address info is updated successfully! Here is the owner after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }
    
    public void removeOwner() {
        if (list.isEmpty()) {
            System.out.println("The list of owner is empty. Please add a new owner!");
            return;
        }
        
        String id, choice;
        int pos;
        id = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
        pos = searchOwnerReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this Owner? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected owner is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
}
