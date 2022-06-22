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
public class PetList {

    ArrayList<Pet> list;

    public PetList() {
        list = new ArrayList<>();
    }

    public void addPet() {
        String id, name, birthday, gender;
        int pos;
        do {
            id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
            pos = searchPetReturnPos(id);
            if (pos != -1) {
                System.out.println("The pet's id already exists. Input another one!");
            }
        } while (pos != -1);
        name = Validation.getString("Input pet's name: ", "Pet's name mustn't empty or contains all whitespace characters. Please input pet's name again!", 1, 15).toUpperCase();
        birthday = Validation.getDateFormat("Input pet's birthday (d/m/y): ", "Pet's birthday must be follow format dd/mm/yyyy. Please input pet's birthday again!", "dd/MM/yyyy", "01/01/1900", new Date());
        gender = Validation.getTwoOption("Input pet's gender (male/female): ", "Pet's gender must be male or female. Please input pet's gender again!", "male", "female");
        list.add(new Pet(id, name, birthday, gender));
        System.out.println("A pet profile is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The pet list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the pet list");
        String header = String.format("|%-6s|%-15s|%-10s|%6s|%6s|", "ID", "NAME", "BIRTHDAY", "GENDER", "OWNER");
        System.out.println(header);
        list.forEach(pet -> {
            pet.output();
        });
    }

    public void searchPet() {
        if (list.isEmpty()) {
            System.out.println("The list of pet is empty. Please add a new pet!");
            return;
        }

        String id;
        Pet x;

        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        x = searchPetReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the Pet that you want to search");
            String header = String.format("|%-6s|%-15s|%-10s|%6s|%6s|", "ID", "NAME", "BIRTHDAY", "GENDER", "OWNER");
            System.out.println(header);
            x.output();
        }
    }

    public int searchPetReturnPos(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public Pet searchPetReturnObj(String id) {
        for (Pet pet : list) {
            if (pet.getId().equalsIgnoreCase(id)) {
                return pet;
            }
        }
        return null;
    }

    public void updatePet() {
        //k khuyen khich cach nay - cach khac la y chang cai kia
        /*int i = searchPet(id);
        if (i == -1) return false;
        Pet p = new Pet();
        p.input();
        list.set(i, p);
        return true; */

        if (list.isEmpty()) {
            System.out.println("The list of pet is empty. Please add a new pet!");
            return;
        }

        String id;
        String newName, newBirthday, newGender;
        Pet x;
        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        x = searchPetReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the Pet before updating");
            String header = String.format("|%-6s|%-15s|%-10s|%6s|%6s|", "ID", "NAME", "BIRTHDAY", "GENDER", "OWNER");
            System.out.println(header);
            x.output();

            Menu updateMenu = new Menu("Pet Update");
            updateMenu.addNewOption("1. Update pet's name");
            updateMenu.addNewOption("2. Update pet's birthday");
            updateMenu.addNewOption("3. Update pet's gender");
            updateMenu.addNewOption("4. Nothing");

            int choice;
            do {
                updateMenu.printMenu();
                choice = updateMenu.getChoice();
                switch (choice) {
                    case 1:
                        System.out.println("You are required to input a new name");
                        newName = Validation.getString("Input pet's name: ", "Pet's name mustn't empty or contains all whitespace characters. Please input pet's name again!", 1, 15).toUpperCase();
                        x.setName(newName);
                        System.out.println("The pet's name is updated successfully! Here is the Pet after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 2:
                        System.out.println("You are required to input a new birthday");
                        newBirthday = Validation.getDateFormat("Input pet's birthday (d/m/y): ", "Pet's birthday must be follow format dd/mm/yyyy. Please input pet's birthday again!", "dd/MM/yyyy", "01/01/1900", new Date());
                        x.setBirthday(newBirthday);
                        System.out.println("The pet's birthday info is updated successfully! Here is the Pet after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 3:
                        System.out.println("You are required to input a new gender");
                        newGender = Validation.getTwoOption("Input pet's gender (male/female): ", "Pet's gender must be male or female. Please input pet's gender again!", "male", "female");
                        x.setGender(newGender);
                        System.out.println("The pet's gender info is updated successfully! Here is the Pet after updating");
                        System.out.println(header);
                        x.output();
                        break;
                    case 4:
                        break;
                }
            } while (choice != 4);
        }
    }

    public void removePet() {
        if (list.isEmpty()) {
            System.out.println("The list of pet is empty. Please add a new pet!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        pos = searchPetReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-6s|%-15s|%-10s|%6s|%6s|", "ID", "NAME", "BIRTHDAY", "GENDER", "OWNER");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this Pet? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected pet is removed successfully!");
            }
        }
    }

    public void sortById() {
        Collections.sort(list);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int getSize () {
        return list.size();
    }
}
