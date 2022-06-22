/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.LogList;
import DTO.Owner;
import DTO.OwnerList;
import DTO.Pet;
import DTO.PetList;
import DTO.ServiceList;
import UI.Menu;
import util.Validation;

/**
 *
 * @author PC
 */
public class HealthHospital {

    public static void main(String[] args) {
        Menu menu = new Menu("Happiness Pet Care System");
        menu.addNewOption("1. Manage pet list");
        menu.addNewOption("2. Manage owner list");
        menu.addNewOption("3. Manage service list");
        menu.addNewOption("4. Update owner information for pet");
        menu.addNewOption("5. Manage the use of services by pets");
        menu.addNewOption("6. Quit");

        PetList pList = new PetList();
        OwnerList oList = new OwnerList();
        ServiceList sList = new ServiceList();
        LogList lList = new LogList(pList, sList);

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to manage pet list");
                    managePetList(pList);
                    break;
                case 2:
                    System.out.println("You are required to manage owner list");
                    manageOwnerList(oList);
                    break;
                case 3:
                    System.out.println("You are required to manage service list");
                    manageServiceList(sList);
                    break;
                case 4:
                    System.out.println("You are required to update owner information for pet");
                    updateOwnerForPet(pList, oList);
                    break;
                case 5:
                    System.out.println("You are required to manage the use of services by pets");
                    managePetUseService(lList, pList, sList);
                    break;
                case 6:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 6);
    }

    public static void managePetList(PetList list) {
        Menu menuPet = new Menu("Pet List Management");
        menuPet.addNewOption("1. Add a new pet profile");
        menuPet.addNewOption("2. Search a pet profile by id");
        menuPet.addNewOption("3. Update a pet profile by id");
        menuPet.addNewOption("4. Remove a pet profile by id");
        menuPet.addNewOption("5. Print the pet list ascending by id");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new pet profile");
                    list.addPet();
                    break;
                case 2:
                    System.out.println("You are required to search a pet profile by id");
                    list.searchPet();
                    break;
                case 3:
                    System.out.println("You are required to update a pet profile by id");
                    list.updatePet();
                    break;
                case 4:
                    System.out.println("You are required to remove a pet profile by id");
                    list.removePet();
                    break;
                case 5:
                    System.out.println("You are required to print the pet list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageOwnerList(OwnerList list) {
        Menu menuPet = new Menu("Owner List Management");
        menuPet.addNewOption("1. Add a new owner profile");
        menuPet.addNewOption("2. Search a owner profile by id");
        menuPet.addNewOption("3. Update a owner profile by id");
        menuPet.addNewOption("4. Remove a owner profile by id");
        menuPet.addNewOption("5. Print the owner list ascending by id");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new owner profile");
                    list.addOwner();
                    break;
                case 2:
                    System.out.println("You are required to search a owner profile by id");
                    list.searchOwner();
                    break;
                case 3:
                    System.out.println("You are required to update a owner profile by id");
                    list.updateOwner();
                    break;
                case 4:
                    System.out.println("You are required to remove a owner profile by id");
                    list.removeOwner();
                    break;
                case 5:
                    System.out.println("You are required to print the owner list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageServiceList(ServiceList list) {
        Menu menuPet = new Menu("Service List Management");
        menuPet.addNewOption("1. Add a new service infomation");
        menuPet.addNewOption("2. Search a service infomation by id");
        menuPet.addNewOption("3. Update a service infomation by id");
        menuPet.addNewOption("4. Remove a service infomation by id");
        menuPet.addNewOption("5. Print the service list ascending by id");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new service infomation");
                    list.addService();
                    break;
                case 2:
                    System.out.println("You are required to search a service infomation by id");
                    list.searchService();
                    break;
                case 3:
                    System.out.println("You are required to update a service infomation by id");
                    list.updateService();
                    break;
                case 4:
                    System.out.println("You are required to remove a service infomation by id");
                    list.removeService();
                    break;
                case 5:
                    System.out.println("You are required to print the service list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void updateOwnerForPet(PetList pList, OwnerList oList) {
        if (pList.isEmpty() || oList.isEmpty()) {
            if (pList.isEmpty()) {
                System.out.println("The list of pet is empty. Please add a new pet!");
            }
            if (oList.isEmpty()) {
                System.out.println("The list of owner is empty. Please add a new owner!");
            }
            return;
        }

        String pId, oId;
        Owner o = null;
        Pet p = null;
        String choice = "";

        do {
            oId = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
            o = oList.searchOwnerReturnObj(oId);
            if (o == null) {
                System.out.println("Not found this owner in owner list. Please input owner's id again!");
            } else {
                System.out.println("Here is the owner have ID: " + oId);
                String header = String.format("|%-6s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
                System.out.println(header);
                o.output();

                do {
                    pId = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
                    p = pList.searchPetReturnObj(pId);
                    if (p == null) {
                        System.out.println("Not found this pet in pet list. Please input pet's id again!");
                    } else {
                        System.out.println("Here is the pet have ID: " + pId);
                        header = String.format("|%-6s|%-15s|%-10s|%6s|%6s|", "ID", "NAME", "BIRTHDAY", "GENDER", "OWNER");
                        System.out.println(header);
                        p.output();

                        if (p.checkOwner(pId) != null) {
                            choice = Validation.getTwoOption("\nThis pet already has an owner, are you sure you still want to update the owner for it? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        } else {
                            choice = Validation.getTwoOption("Are you sure you want to update the owner " + oId + " for pet " + pId + "? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        }
                        switch (choice) {
                            case "y":
                                p.setOwner(o);
                                System.out.println("After update, here is the pet have ID: " + pId);
                                System.out.println(header);
                                p.output();
                                break;
                            case "n":
                                break;
                        }
                        System.out.println("");
                        choice = Validation.getTwoOption("Do you want to update this owner's ownership with another pet? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                    }
                } while (p == null || choice.equalsIgnoreCase("y"));
                choice = Validation.getTwoOption("Do you want to continue updating owner information for pet? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            }
        } while (o == null || choice.equalsIgnoreCase("y"));
    }
    
    public static void managePetUseService(LogList list, PetList pList, ServiceList sList) {
        if (pList.isEmpty() || sList.isEmpty()) {
            if (pList.isEmpty()) {
                System.out.println("The list of pet is empty. Please add a new pet!");
            }
            if (sList.isEmpty()) {
                System.out.println("The list of owner is empty. Please add a new owner!");
            }
            return;
        }
        
        Menu menuPet = new Menu("Log List Management");
        menuPet.addNewOption("1. Add a new log");
        menuPet.addNewOption("2. Search logs by pet's id");
        menuPet.addNewOption("3. Remove a log by pet's id");
        menuPet.addNewOption("4. Print the log list ascending by index");
        menuPet.addNewOption("5. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new log");
                    list.addLog();
                    break;
                case 2:
                    System.out.println("You are required to search logs by pet's id");
                    list.searchLogsOfAPet();
                    break;
                case 3:
                    System.out.println("You are required to remove a log by pet's id");
                    list.removeALog();
                    break;
                case 4:
                    System.out.println("You are required to print the log list ascending by index");
                    list.displayAll();
                    break;
                case 5:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 5);
    }

}
