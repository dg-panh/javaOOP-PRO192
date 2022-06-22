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
public class ItemList {
    ArrayList<Item> list;
    
    public ItemList() {
        list = new ArrayList<>();
    }
    
    public void addItem() {
        String id, name, status;
        double price;
        int pos;
        do {
            id = Validation.getID("Input item id (ITXXXXXX): ", "The format of code is ITXXXXXX (X stands for a digit)", "^[I|i][T|t]\\d{6}$");
            pos = searchItemReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input item name: ", "Name mustn't empty or contains all whitespace characters. Please input Input item name again!", 1, 15).toUpperCase();
        price = Validation.getADouble("Input item price: ", "Price must be from 1 to 999999.9. Please input item price again!", 1, 999999.9);
        status = Validation.getTwoOption("Input status (0/1): ", "Your choice must be 0 or 1. Please input your choice again!", "0", "1");
        list.add(new Item(id, name, price, status));
        System.out.println("A item infomation is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The item list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the item list");
        String header = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
        System.out.println(header);
        list.forEach(item -> {
            item.output();
        });
    }
    
    public void searchItem() {
        if (list.isEmpty()) {
            System.out.println("The list of item is empty. Please add a new item!");
            return;
        }
        
        String id;
        Item x;  
        
        id = Validation.getID("Input item id (ITXXXXXX): ", "The format of code is ITXXXXXX (X stands for a digit)", "^[I|i][T|t]\\d{6}$");
        x = searchItemReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the item that you want to search");
            String header = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchItemReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id))
                return i;
        }
        return -1;
    }
    
    public Item searchItemReturnObj(String id) {
        for (Item o : list) {
            if (o.getId().equalsIgnoreCase(id))
                return o;
        }
        return null;
    }
    
    public void updateItem() {
        if (list.isEmpty()) {
            System.out.println("The list of item is empty. Please add a new item!");
            return;
        }
        
        String id, newName, newStatus; 
        Double newPrice;
        Item x;
        id = Validation.getID("Input item id (ITXXXXXX): ", "The format of code is ITXXXXXX (X stands for a digit)", "^[I|i][T|t]\\d{6}$");
        x = searchItemReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the item before updating");
            String header = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Item Update");
            updateMenu.addNewOption("1. Update item name");
            updateMenu.addNewOption("2. Update item price");
            updateMenu.addNewOption("3. Update item status");
            updateMenu.addNewOption("4. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input item name: ", "Name mustn't empty or contains all whitespace characters. Please input Input item name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The item name is updated successfully! Here is the item after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new price");
                        newPrice = Validation.getADouble("Input item price: ", "Price must be from 1 to 999999.9. Please input item price again!", 1, 999999.9);
                        x.setPrice(newPrice);
                        System.out.println("The item price is updated successfully! Here is the item after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new status");
                        newStatus = Validation.getTwoOption("Input status (0/1): ", "Your choice must be 0 or 1. Please input your choice again!", "0", "1");
                        x.setStatus(newStatus);
                        System.out.println("The item price is updated successfully! Here is the item after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        break;
                }
            } while (choice != 4);
        }
    }
    
    public void removeItem() {
        if (list.isEmpty()) {
            System.out.println("The list of item is empty. Please add a new item!");
            return;
        }
        
        String id, choice;
        int pos;
        id = Validation.getID("Input item id (ITXXXXXX): ", "The format of code is ITXXXXXX (X stands for a digit)", "^[I|i][T|t]\\d{6}$");
        pos = searchItemReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this item? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected item is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
