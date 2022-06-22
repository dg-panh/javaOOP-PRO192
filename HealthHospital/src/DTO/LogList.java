/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import util.Validation;

/**
 *
 * @author PC
 */
public class LogList {

    ArrayList<Log> list;
    PetList listP;
    ServiceList listS;

    public LogList(PetList listP, ServiceList listS) {
        list = new ArrayList<>();
        this.listP = listP;
        this.listS = listS;
    }

    public void addLog() {
        String idP, idS;
        Pet p;
        Service s;
        do {
            idP = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
            p = listP.searchPetReturnObj(idP);
            if (p == null) {
                System.out.println("Not found this pet in pet list. Please input pet's id again!");
            }
        } while (p == null);

        do {
            idS = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
            s = listS.searchServiceReturnObj(idS);
            if (s == null) {
                System.out.println("Not found this service in service list. Please input service's id again!");
            }
        } while (s == null);

        list.add(new Log(p, s));
        int i = list.size();
        list.get(i - 1).setIndex(i);
        System.out.println("A log is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The log list is empty. Nothing to print");
            return;
        }
        //Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is/are log(s) list");
        String header = String.format("|%16s|%-22s|%-30s|", " ", "PET", "SERVICE");
        String subheader = String.format("|%5s|%10s|%-6s|%-15s|%-6s|%-15s|%7s|", "INDEX", "DATE", "ID", "NAME", "ID", "NAME", "PRICE");
        System.out.println(header);
        System.out.println(subheader);
        for (int i = 0; i < list.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                list.get(i).output();
        }
    }

    public void searchLogsOfAPet() {
        if (list.isEmpty()) {
            System.out.println("The list of log is empty. Please add a new log!");
            return;
        }

        String id;
        ArrayList<Log> listSearch;

        //listSearch = searchLogByDate();
        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        listSearch = searchLogsByPetId(id);
        //Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is/are log(s) of a pet that you want to search");
            String header = String.format("|%16s|%-22s|%-30s|", " ", "PET", "SERVICE");
            String subheader = String.format("|%5s|%10s|%-6s|%-15s|%-6s|%-15s|%7s|", "INDEX", "DATE", "ID", "NAME", "ID", "NAME", "PRICE");
            System.out.println(header);
            System.out.println(subheader);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearch.get(i).output();
            }
        }
    }

    public ArrayList<Log> searchLogByDate() {
        ArrayList<Log> listSearch = new ArrayList<>();
        String date = Validation.getDateFormat("Input date (dd/MM/yyyy): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", "01/01/1900", new Date());
        for (Log log : list) {
            if (log.getDate().equalsIgnoreCase(date)) {
                listSearch.add(log);
            }
        }
        return listSearch;
    }

    public ArrayList<Log> searchLogsByPetId(String id) {
        ArrayList<Log> listSearch = new ArrayList<>();
        for (Log log : list) {
            if (log.getPet().getId().equalsIgnoreCase(id)) {
                listSearch.add(log);
            }
        }
        return listSearch;
    }
    
    public Log searchLogByIndex(int index) {
        for (Log log : list) {
            if (log.getIndex() == index) {
                return log;
            }
        }
        return null;
    }

    public void removeALog() {
        if (list.isEmpty()) {
            System.out.println("The list of log is empty. Please add a new log!");
            return;
        }

        String id, choice;
        int pos, tmpIndex;
        Log l;
        ArrayList<Log> listSearch;

        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        listSearch = searchLogsByPetId(id);
        Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else { 
            
            System.out.println("Here is/are log(s) of pet has ID: " + id);
            String header = String.format("|%16s|%-22s|%-30s|", " ", "PET", "SERVICE");
            String subheader = String.format("|%5s|%10s|%-6s|%-15s|%-6s|%-15s|%7s|", "INDEX", "DATE", "ID", "NAME", "ID", "NAME", "PRICE");
            System.out.println(header);
            System.out.println(subheader);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearch.get(i).output();
            }
            
            int maxOption = listSearch.size();
            String inputMsg = "Input the index you want to remove (1.." + maxOption + "): ";
            String errorMsg = "You are required to choose the index 1.." + maxOption + ". Please input the index again!";
            pos = Validation.getAnInteger(inputMsg, errorMsg, 1, maxOption);
            tmpIndex = listSearch.get(pos - 1).getIndex();
            
            System.out.println("Here is a log of pet that you want to remove");
            header = String.format("%11s|%-22s|%-30s|", " ", "PET", "SERVICE");
            subheader = String.format("|%10s|%-6s|%-15s|%-6s|%-15s|%7s|", "DATE", "ID", "NAME", "ID", "NAME", "PRICE");
            System.out.println(header);
            System.out.println(subheader);
            l = searchLogByIndex(tmpIndex);
            
            choice = Validation.getTwoOption("\nAre you sure you want to delete this log? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(l);
                System.out.println("The selected pet is removed successfully!");
            }
        }
    }
}
