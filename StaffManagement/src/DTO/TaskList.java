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
public class TaskList {
    ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }
    
    public void addTask() {
        String id, title, beginDate, endDate;
        int pos;
        do {
            id = Validation.getString("Input task's id: ", "Id mustn't empty or contains all whitespace characters. Please input task's id again!", 1, 6).toUpperCase();
            pos = searchTaskReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        title = Validation.getString("Input task's title: ", "Title mustn't empty or contains all whitespace characters. Please input task's title again!", 1, 15).toUpperCase();
        beginDate =  Validation.getDateFormat("Input task's begin date (d/m/y h:m): ", "Date must be follow format dd/mm/yyyy h:m. Please input task's begin date again!", "dd/MM/yyyy HH:mm", "01/01/2020 00:00");      
        endDate = Validation.getDateFormat("Input task's end date (d/m/y h:m): ", "Date must be follow format dd/mm/yyyy h:m. Please input task's end date again!", "dd/MM/yyyy HH:mm", "01/01/2020 00:00"); 
        while (!(new Task(id, title, beginDate, endDate)).checkEndDate(endDate)) {
            System.out.println("Please input end date again!");
            endDate = Validation.getDateFormat("Input task's end date (d/m/y h:m): ", "Date must be follow format dd/mm/yyyy h:m. Please input task's end date again!", "dd/MM/yyyy HH:mm", "01/01/2020 00:00"); 
        }
        list.add(new Task(id, title, beginDate, endDate));
        System.out.println("A task information is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The task list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the task list");
        String header = String.format("|%-6s|%-15s|%16s|%16s|%11s|", "ID", "TITLE", "BEGIN DATE", "END DATE", "TOTAL HOURSE");
        System.out.println(header);
        list.forEach(task -> {
            task.output();
        });
    }

    public void searchTask() {
        if (list.isEmpty()) {
            System.out.println("The list of task is empty. Please add a new task!");
            return;
        }

        String id;
        Task x;

        id = Validation.getString("Input task's id: ", "Id mustn't empty or contains all whitespace characters. Please input task's id again!", 1, 6).toUpperCase();
        x = searchTaskReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the task that you want to search");
            String header = String.format("|%-6s|%-15s|%16s|%16s|%11s|", "ID", "TITLE", "BEGIN DATE", "END DATE", "TOTAL HOURSE");
            System.out.println(header);
            x.output();
        }
    }

    public int searchTaskReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Task searchTaskReturnObj(String id) {
        for (Task task : list) {
            if (task.getId().equalsIgnoreCase(id)) {
                return task;
            }
        }
        return null;
    }

    public void updateTask() {
        if (list.isEmpty()) {
            System.out.println("The list of task is empty. Please add a new task!");
            return;
        }

        String id, newTitle, newBDate, newEDate;
        Task x;
        id = Validation.getString("Input task's id: ", "Id mustn't empty or contains all whitespace characters. Please input task's id again!", 1, 6).toUpperCase();
        x = searchTaskReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the task before updating");
            String header = String.format("|%-6s|%-15s|%16s|%16s|%11s|", "ID", "TITLE", "BEGIN DATE", "END DATE", "TOTAL HOURSE");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Task Update");
            updateMenu.addNewOption("1. Update task's title");
            updateMenu.addNewOption("2. Update task's begin date");
            updateMenu.addNewOption("3. Update task's end date");
            updateMenu.addNewOption("4. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new title");
                        newTitle = Validation.getString("Input task's title: ", "Name mustn't empty or contains all whitespace characters. Please input task's title again!", 1, 15).toUpperCase();
                        x.setTitle(newTitle);
                        System.out.println("The task's title is updated successfully! Here is the task after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new begin date");
                        newBDate = Validation.getDateFormat("Input task's begin date (d/m/y h:m): ", "Date must be follow format dd/mm/yyyy h:m. Please input task's begin date again!", "dd/MM/yyyy HH:mm", "01/01/2020 00:00");
                        x.setBeginDate(newBDate);
                        x.setTotalHours();
                        System.out.println("The task's begin date is updated successfully! Here is the task after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new end date");
                        newEDate = Validation.getDateFormat("Input task's end date (d/m/y h:m): ", "Date must be follow format dd/mm/yyyy h:m. Please input task's end date again!", "dd/MM/yyyy HH:mm", "01/01/2020 00:00");
                        x.setEndDate(newEDate);
                        x.setTotalHours();
                        System.out.println("The task's end date is updated successfully! Here is the task after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        break;
                }
            } while (choice != 4);
        }
    }

    public void removeTask() {
        if (list.isEmpty()) {
            System.out.println("The list of task is empty. Please add a new task!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getString("Input task's id: ", "Id mustn't empty or contains all whitespace characters. Please input task's id again!", 1, 6).toUpperCase();
        pos = searchTaskReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%16s|%16s|%11s|", "ID", "TITLE", "BEGIN DATE", "END DATE", "TOTAL HOURSE");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this task? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected task is removed successfully!");
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
