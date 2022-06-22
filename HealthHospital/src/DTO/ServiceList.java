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
public class ServiceList {
    ArrayList<Service> list;

    public ServiceList() {
        list = new ArrayList<>();
    }
    
    public void addService() {
        String id, name;
        Double price;
        int pos;
        do {
            id = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
            pos = searchServicerReturnPos(id);
            if (pos != -1) {
                System.out.println("The service's id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input service's name: ", "Service's name mustn't empty or contains all whitespace characters. Please input service's name again!", 1, 15).toUpperCase();
        price = Validation.getADouble("Input service's price: ", "Service's price must be from 1 to 999999.9. Please input service's price again!", 1, 999999.9);
        list.add(new Service(id, name, price));
        System.out.println("A service infomation is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The service list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the service list");
        String header = String.format("|%-6s|%-15s|%7s|", "ID", "NAME", "PRICE");
        System.out.println(header);
        list.forEach(service -> {
            service.output();
        });
    }
    
    public void searchService() {
        if (list.isEmpty()) {
            System.out.println("The list of service is empty. Please add a new service!");
            return;
        }
        
        String id;
        Service x;  
        
        id = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
        x = searchServiceReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the service that you want to search");
            String header = String.format("|%-6s|%-15s|%7s|", "ID", "NAME", "PRICE");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchServicerReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public Service searchServiceReturnObj(String id) {
        for (Service o : list) {
            if (o.getId().equalsIgnoreCase(id))
                return o;
        }
        return null;
    }
    
    public void updateService() {
        if (list.isEmpty()) {
            System.out.println("The list of service is empty. Please add a new service!");
            return;
        }
        
        String id, newName; 
        Double newPrice;
        Service x;
        id = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
        x = searchServiceReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the service before updating");
            String header = String.format("|%-6s|%-15s|%7s|", "ID", "NAME", "PRICE");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Service Update");
            updateMenu.addNewOption("1. Update service's name");
            updateMenu.addNewOption("2. Update service's price");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input service's name: ", "Service's name mustn't empty or contains all whitespace characters. Please input service's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The service's name is updated successfully! Here is the service after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new price");
                        newPrice = Validation.getADouble("Input service's price: ", "Service's price must be from 1 to 999999.9. Please input service's price again!", 1, 999999.9);
                        x.setPrice(newPrice);
                        System.out.println("The service's price is updated successfully! Here is the service after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }
    
    public void removeService() {
        if (list.isEmpty()) {
            System.out.println("The list of service is empty. Please add a new service!");
            return;
        }
        
        String id, choice;
        int pos;
        id = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
        pos = searchServicerReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%7s|", "ID", "NAME", "PRICE");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this Owner? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected service is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
}
