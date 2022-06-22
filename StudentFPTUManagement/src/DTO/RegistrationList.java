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
public class RegistrationList {

    ArrayList<Registration> list;
    StudentList listS;
    CourseList listC;

    public RegistrationList(StudentList listS, CourseList listC) {
        this.listS = listS;
        this.listC = listC;
        list = new ArrayList<>();
    }

    public void addRegistration() {
        String id, code;
        Student s;
        Course c;
        do {
            id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
            s = listS.searchStudentReturnObj(id);
            if (s == null) {
                System.out.println("Not found this student in list. Please input id again!");
            }
        } while (s == null);

        do {
            code = Validation.getID("Input course's code (CRXXX): ", "The format of code is CRXXX (X stands for a digit)", "^[C|c][R|r]\\d{3}$");
            c = listC.searchCourseReturnObj(code);
            if (c == null) {
                System.out.println("Not found this course in course list. Please input course's id again!");
            }
        } while (c == null);

        list.add(new Registration(s, c));
        int i = list.size();
        list.get(i - 1).setIndex(i);
        System.out.println("A registration is added successfully!");
    }
    
    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The registration list is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is/are registration list");
        String header = String.format("|%5s|%-24s|%-29s|", " ", "STUDENT", "COURSE");
        String subheader = String.format("|%5s|%-8s|%-15s|%-5s|%-15s|%7s|", "INDEX", "ID", "NAME", "ID", "NAME", "CREDITS");
        System.out.println(header);
        System.out.println(subheader);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("|%5d", (i + 1));
            list.get(i).output();
        }
    }
    
    public void searchRegistrationByStudentID() {
        if (list.isEmpty()) {
            System.out.println("The list of registration is empty. Please add a new registration!");
            return;
        }

        String id;
        ArrayList<Registration> listSearch;

        id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
        listSearch = searchRegistrationReturnList(id);
        //Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is/are registration(s) of a student that you want to search");
            String header = String.format("|%5s|%-24s|%-29s|", " ", "STUDENT", "COURSE");
            String subheader = String.format("|%5s|%-8s|%-15s|%-5s|%-15s|%7s|", "INDEX", "ID", "NAME", "ID", "NAME", "CREDITS");
            System.out.println(header);
            System.out.println(subheader);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearch.get(i).output();
            }
        }
    }
    
    public ArrayList<Registration> searchRegistrationReturnList(String id) {
        ArrayList<Registration> listSearch = new ArrayList<>();
        for (Registration r : list) {
            if (r.getStudent().getId().equalsIgnoreCase(id)) {
                listSearch.add(r);
            }
        }
        return listSearch;
    }
    
    public Registration searchRegistrationByIndex(int index) {
        for (Registration r : list) {
            if (r.getIndex() == index) {
                return r;
            }
        }
        return null;
    }

    public void removeAregistration() {
        if (list.isEmpty()) {
            System.out.println("The list of registration is empty. Please add a new registration!");
            return;
        }

        String id, choice;
        int pos, tmpIndex;
        Registration t;
        ArrayList<Registration> listSearch;

        id = Validation.getID("Input student's id (SEXXXXXX): ", "The format of id is SEXXXXXX (X stands for a digit)", "^[S|s][E|e]\\d{6}$");
        listSearch = searchRegistrationReturnList(id);
        Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {

            System.out.println("Here is/are registration(s) of student has ID: " + id);
            String header = String.format("|%5s|%-24s|%-29s|", " ", "STUDENT", "COURSE");
            String subheader = String.format("|%5s|%-8s|%-15s|%-5s|%-15s|%7s|", "INDEX", "ID", "NAME", "ID", "NAME", "CREDITS");
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

            System.out.println("Here is a registration of a student that you want to remove");
            header = String.format("|%-24s|%-29s|", "STUDENT", "COURSE");
            subheader = String.format("|%-8s|%-15s|%-5s|%-15s|%7s|", "ID", "NAME", "ID", "NAME", "CREDITS");
            System.out.println(header);
            System.out.println(subheader);
            t = searchRegistrationByIndex(tmpIndex);
            t.output();

            choice = Validation.getTwoOption("\nAre you sure you want to delete this registration? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(t);
                System.out.println("The selected registration is removed successfully!");
            }
        }
    }

}
