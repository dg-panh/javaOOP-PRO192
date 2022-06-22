/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Collections;
import util.Validation;

/**
 *
 * @author PC
 */
public class TimeSheetList {

    ArrayList<TimeSheet> list;
    StaffList listS;
    TaskList listT;

    public TimeSheetList(StaffList listS, TaskList listT) {
        list = new ArrayList<>();
        this.listS = listS;
        this.listT = listT;
    }

    public void addTimesheet() {
        String idS, idT;
        Staff s;
        Task t;
        do {
            idS = Validation.getString("Input staff's/manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
            s = listS.searchStaffReturnObj(idS);
            if (s == null) {
                System.out.println("Not found this staff/manager in list. Please input id again!");
            }
        } while (s == null);

        do {
            idT = Validation.getString("Input task's id: ", "Id mustn't empty or contains all whitespace characters. Please input task's id again!", 1, 6).toUpperCase();
            t = listT.searchTaskReturnObj(idT);
            if (t == null) {
                System.out.println("Not found this task in task list. Please input task's id again!");
            }
        } while (t == null);

        list.add(new TimeSheet(s, t));
        int i = list.size();
        list.get(i - 1).setIndex(i);
        System.out.println("A log is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The timesheets list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is/are timesheet list");
        String header = String.format("|%5s|%-22s|%-35s|", " ", "EMPLOYEE", "TASK");
        String subheader = String.format("|%5s|%-6s|%-15s|%-6s|%-15s|%12s|", "INDEX", "ID", "NAME", "ID", "NAME", "TOTAL HOURS");
        System.out.println(header);
        System.out.println(subheader);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%5d", (i + 1));
            list.get(i).output();
        }
    }

    public void searchTimesheetByStaffID() {
        if (list.isEmpty()) {
            System.out.println("The list of timesheets is empty. Please add a new timesheets!");
            return;
        }

        String id;
        ArrayList<TimeSheet> listSearch;

        id = Validation.getString("Input staff's/manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        listSearch = searchTimesheetReturnList(id);
        //Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is/are timesheet(s) of a staff/manager that you want to search");
            String header = String.format("|%5s|%-22s|%-35s|", " ", "EMPLOYEE", "TASK");
            String subheader = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            System.out.println(subheader);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearch.get(i).output();
            }
        }
    }

    public ArrayList<TimeSheet> searchTimesheetReturnList(String id) {
        ArrayList<TimeSheet> listSearch = new ArrayList<>();
        for (TimeSheet timesheet : list) {
            if (timesheet.getStaff().getId().equalsIgnoreCase(id)) {
                listSearch.add(timesheet);
            }
        }
        return listSearch;
    }
    
    public TimeSheet searchTimesheetByIndex(int index) {
        for (TimeSheet timeSheet : list) {
            if (timeSheet.getIndex() == index) {
                return timeSheet;
            }
        }
        return null;
    }

    public void removeATimesheet() {
        if (list.isEmpty()) {
            System.out.println("The list of timesheets is empty. Please add a new timesheet!");
            return;
        }

        String id, choice;
        int pos, tmpIndex;
        TimeSheet t;
        ArrayList<TimeSheet> listSearch;

        id = Validation.getString("Input staff's/manager's id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        listSearch = searchTimesheetReturnList(id);
        Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {

            System.out.println("Here is/are timesheet(s) of staff/manager has ID: " + id);
            String header = String.format("|%5s|%-22s|%-35s|", " ", "EMPLOYEE", "TASK");
            String subheader = String.format("|%5s|%-6s|%-15s|%-6s|%-15s|%12s|", "INDEX", "ID", "NAME", "ID", "NAME", "TOTAL HOURS");
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
            tmpIndex = listSearch.get(pos - 1).getIndex(); //bien tmp luu index cua timesheet

            System.out.println("Here is a timesheet of staff/manager that you want to remove");
            header = String.format("|%-22s|%-35s|", "EMPLOYEE", "TASK");
            subheader = String.format("|%-6s|%-15s|%-6s|%-15s|%12s|", "ID", "NAME", "ID", "NAME", "TOTAL HOURS");
            System.out.println(header);
            System.out.println(subheader);
            t = searchTimesheetByIndex(tmpIndex);
            t.output();

            choice = Validation.getTwoOption("\nAre you sure you want to delete this timesheet? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(t);
                System.out.println("The selected timesheet is removed successfully!");
            }
        }
    }
}
