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
public class CustomerList {
    ArrayList<Customer> list;
    
    public CustomerList() {
        list = new ArrayList<>();
    }
    
    public void addCustomer() {
        String id, name, address;
        int pos;
        do {
            id = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
            pos = searchCustomerReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input customer's name: ", "Name mustn't empty or contains all whitespace characters. Please input customer's name again!", 1, 15).toUpperCase();
        address = Validation.getString("Input customer's address: ", "Address mustn't empty or contains all whitespace characters. Please input customer's address again!", 1, 20);       
        list.add(new Customer(id, name, address));
        System.out.println("A customer profile is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list of customer is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the customer list");
        String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }
    
    public void searchCustomer() {
        if (list.isEmpty()) {
            System.out.println("The list of customer is empty. Please add a new customer!");
            return;
        }
        
        String id;
        Customer x;  
        
        id = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
        x = searchCustomerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the customer that you want to search");
            String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchCustomerReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public Customer searchCustomerReturnObj(String id) {
        for (Customer o : list) {
            if (o.getId().equalsIgnoreCase(id))
                return o;
        }
        return null;
    }
    
    public void updateCustomer() {
        if (list.isEmpty()) {
            System.out.println("The list of customer is empty. Please add a new customer!");
            return;
        }
        
        String id, newName, newAddress;
        Customer x;
        id = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
        x = searchCustomerReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the customer before updating");
            String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Customer Update");
            updateMenu.addNewOption("1. Update customer's name");
            updateMenu.addNewOption("2. Update customer's address");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input customer's name: ", "Name mustn't empty or contains all whitespace characters. Please input customer's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The customer's name is updated successfully! Here is the customer after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new address");
                        newAddress = Validation.getString("Input customer's address: ", "Address mustn't empty or contains all whitespace characters. Please input customer's address again!", 1, 20);
                        x.setAddress(newAddress);
                        System.out.println("The customer's address is updated successfully! Here is the customer after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }
    
    public void removeCustomer() {
        if (list.isEmpty()) {
            System.out.println("The list of customer is empty. Please add a new customer!");
            return;
        }
        
        String id, choice;
        int pos;
        id = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
        pos = searchCustomerReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this customer? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected customer is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
