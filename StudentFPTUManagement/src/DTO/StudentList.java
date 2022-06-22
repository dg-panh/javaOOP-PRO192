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
public class StudentList {

    ArrayList<Student> list;

    public StudentList() {
        list = new ArrayList<>();
    }

    public void addStudent() {
        String id, name, gender, address;
        int pos;
        do {
            id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
            pos = searchStudentReturnPos(id);
            if (pos != -1) {
                System.out.println("The student's id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input student's name: ", "Name mustn't empty or contains all whitespace characters. Please input student's name again!", 1, 15).toUpperCase();
        gender = Validation.getTwoOption("Input student's gender (male/female): ", "Gender must be male or female. Please input student's gender again!", "male", "female");
        address = Validation.getString("Input student's address: ", "Address mustn't empty or contains all whitespace characters. Please input student's address again!", 1, 20);
        list.add(new Student(id, name, gender, address));
        System.out.println("A student profile is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The student list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the student list");
        String header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
        System.out.println(header);
        list.forEach(student -> {
            student.output();
        });
    }

    public void searchStudent() {
        if (list.isEmpty()) {
            System.out.println("The list of student is empty. Please add a new student!");
            return;
        }

        String id;
        Student x;

        id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
        x = searchStudentReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the owner that you want to search");
            String header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
            System.out.println(header);
            x.output();
        }
    }

    public int searchStudentReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student searchStudentReturnObj(String id) {
        for (Student o : list) {
            if (o.getId().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }

    public void updateStudent() {
        if (list.isEmpty()) {
            System.out.println("The list of student is empty. Please add a new student!");
            return;
        }

        String id, newName, newAddress, newGender;
        Student x;
        id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
        x = searchStudentReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the student before updating");
            String header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Student Update");
            updateMenu.addNewOption("1. Update student's name");
            updateMenu.addNewOption("2. Update student's gender");
            updateMenu.addNewOption("3. Update student's address");
            updateMenu.addNewOption("4. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input student's name: ", "Name mustn't empty or contains all whitespace characters. Please input student's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The student's name is updated successfully! Here is the student after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new gender");
                        newGender = Validation.getTwoOption("Input student's gender (male/female): ", "Gender must be male or female. Please input student's gender again!", "male", "female");
                        x.setGender(newGender);
                        System.out.println("The student's gender is updated successfully! Here is the student after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new address");
                        newAddress = Validation.getString("Input student's address: ", "Address mustn't empty or contains all whitespace characters. Please input student's address again!", 1, 20);
                        x.setAddress(newAddress);
                        System.out.println("The student's address is updated successfully! Here is the student after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        break;
                }
            } while (choice != 4);
        }
    }

    public void removeStudent() {
        if (list.isEmpty()) {
            System.out.println("The list of student is empty. Please add a new student!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
        pos = searchStudentReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-8s|%-15s|%6s|%20s|%4s|", "ID", "NAME", "GENDER", "ADDRESS", "CAMPUS");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this student? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected student is removed successfully!");
            }
        }
    }

    public void printListStudentByCampus(String code) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCampus() != null) {
                if (list.get(i).getCampus().getCode().equalsIgnoreCase(code)) {
                    list.get(i).output();
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("None");
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
