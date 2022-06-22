/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import UI.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import util.Validation;

/**
 *
 * @author PC
 */
public class OrderList {
    ArrayList<Order> list;
    
    public OrderList() {
        list = new ArrayList<>();
    }
    
    public void addOrder() {
        String id, orderDate, shipDate;
        int pos;
        do {
            id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
            pos = searchOrderReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        orderDate =  Validation.getDateFormat("Input order date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input order date again!", "dd/MM/yyyy", "01/01/2020", new Date());      
        shipDate = Validation.getDateFormat("Input ship date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input order date again!", "dd/MM/yyyy", "01/01/2020"); 
        while (!(new Order(id, orderDate, shipDate)).checkShipDate(shipDate)) {
            System.out.println("Please input end date again!");
            shipDate = Validation.getDateFormat("Input ship date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input ship date again!", "dd/MM/yyyy", "01/01/2020"); 
        }
        list.add(new Order(id, orderDate, shipDate));
        System.out.println("A order information is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The order list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the order list");
        String header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
        System.out.println(header);
        list.forEach(task -> {
            task.output();
        });
    }

    public void searchOrder() {
        if (list.isEmpty()) {
            System.out.println("The list of order is empty. Please add a new order!");
            return;
        }

        String id;
        Order x;

        id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
        x = searchOrderReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the order that you want to search");
            String header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
            System.out.println(header);
            x.output();
        }
    }

    public int searchOrderReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Order searchOrderReturnObj(String id) {
        for (Order order : list) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order;
            }
        }
        return null;
    }

    public void updateOrder() {
        if (list.isEmpty()) {
            System.out.println("The list of order is empty. Please add a new order!");
            return;
        }

        String id, newODate, newSDate;
        Order x;
        id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
        x = searchOrderReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the order before updating");
            String header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Order Update");
            updateMenu.addNewOption("1. Update order date");
            updateMenu.addNewOption("2. Update ship date");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new order date");
                        newODate = Validation.getDateFormat("Input order date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input order date again!", "dd/MM/yyyy", "01/01/2020", new Date());
                        x.setOrderDate(newODate);
                        System.out.println("The order date is updated successfully! Here is the order after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new ship date");
                        newSDate = Validation.getDateFormat("Input ship date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input order date again!", "dd/MM/yyyy", "01/01/2020"); 
                        x.setShipDate(newSDate);
                        System.out.println("The ship date is updated successfully! Here is the order after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }

    public void removeOrder() {
        if (list.isEmpty()) {
            System.out.println("The list of order is empty. Please add a new order!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
        pos = searchOrderReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this order? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected order is removed successfully!");
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public void printListOrderByCustomer(String id) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCustomer() != null) {
                if (list.get(i).getCustomer().getId().equalsIgnoreCase(id)) {
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
