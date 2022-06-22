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
public class CourseList {
    ArrayList<Course> list;
    
    public CourseList() {
        list = new ArrayList<>();
    }
    
    public void addCourse() {
        String code, name;
        int pos, credits;
        do {
            code = Validation.getID("Input course's code (CRXXX): ", "The format of code is CRXXX (X stands for a digit)", "^[C|c][R|r]\\d{3}$");
            pos = searchCourseReturnPos(code);
            if (pos != -1) {
                System.out.println("The code already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input course's name: ", "Name mustn't empty or contains all whitespace characters. Please input course's name again!", 1, 15).toUpperCase();
        credits = Validation.getAnInteger("Input course's credits: ", "Credits must be a positive integer between 1 and 10", 1, 10);
        list.add(new Course(code, name, credits));
        System.out.println("A course information is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list of course is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the course list");
        String header = String.format("|%-5s|%-15s|%7s|", "CODE", "NAME", "CREDITS");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }
    
    public void searchCourse() {
        if (list.isEmpty()) {
            System.out.println("The list of course is empty. Please add a new course!");
            return;
        }
        
        String code;
        Course x;  
        
        code = Validation.getID("Input course's code (CRXXX): ", "The format of code is CRXXX (X stands for a digit)", "^[C|c][R|r]\\d{3}$");
        x = searchCourseReturnObj(code);
        System.out.println("------------------------------------");
        if (x == null)
            System.out.println("Not found!!!");
        else {
            System.out.println("Here is the course that you want to search");
            String header = String.format("|%-5s|%-15s|%7s|", "CODE", "NAME", "CREDITS");
            System.out.println(header);
            x.output();
        }   
    }
    
    public int searchCourseReturnPos(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equalsIgnoreCase(code))
                return i;
        }
        return -1;
    }
    
    public Course searchCourseReturnObj(String code) {
        for (Course o : list) {
            if (o.getCode().equalsIgnoreCase(code))
                return o;
        }
        return null;
    }
    
    public void updateCourse() {
        if (list.isEmpty()) {
            System.out.println("The list of course is empty. Please add a new course!");
            return;
        }
        
        String code, newName;
        int newCredits;
        Course x;
        code = Validation.getID("Input course's code (CRXXX): ", "The format of code is CRXXX (X stands for a digit)", "^[C|c][R|r]\\d{3}$");
        x = searchCourseReturnObj(code);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the course before updating");
            String header = String.format("|%-5s|%-15s|%7s|", "CODE", "NAME", "CREDITS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Course Update");
            updateMenu.addNewOption("1. Update course's name");
            updateMenu.addNewOption("2. Update course's credits");
            updateMenu.addNewOption("3. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input course's name: ", "Name mustn't empty or contains all whitespace characters. Please input course's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The course's name is updated successfully! Here is the course after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new credits");
                        newCredits = Validation.getAnInteger("Input course's credits: ", "Credits must be a positive integer between 1 and 10", 1, 10);
                        x.setCredits(newCredits);
                        System.out.println("The course's credits is updated successfully! Here is the course after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        break;
                }
            } while (choice != 3);
        }
    }
    
    public void removeCourse() {
        if (list.isEmpty()) {
            System.out.println("The list of course is empty. Please add a new course!");
            return;
        }
        
        String code, choice;
        int pos;
        code = Validation.getID("Input course's code (CRXXX): ", "The format of code is CRXXX (X stands for a digit)", "^[C|c][R|r]\\d{3}$");
        pos = searchCourseReturnPos(code);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-5s|%-15s|%7s|", "CODE", "NAME", "CREDITS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this course? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected course is removed successfully!");
            }
        }
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
