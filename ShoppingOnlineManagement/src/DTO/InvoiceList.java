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
public class InvoiceList {

    ArrayList<Invoice> list;

    public InvoiceList() {
        list = new ArrayList<>();
    }

    public void addInvoice() {
        String id, date;
        int pos;
        do {
            id = Validation.getID("Input invoice id (IVXXXXXX): ", "The format of code is IVXXXXXX (X stands for a digit)", "^[I|i][V|v]\\d{6}$");
            pos = searchInvoiceReturnPos(id);
            if (pos != -1) {
                System.out.println("The id already exists. Input another one!");
            }
        } while (pos != -1);
        date = Validation.getDateFormat("Input date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", "01/01/2020", new Date());
        list.add(new Invoice(id, date));
        System.out.println("A invoice information is added successfully!");
    }

    public void displayAll() {
        if (list.isEmpty()) {
            System.out.println("The list of invoice is empty. Nothing to print");
            return;
        }
        Collections.sort(list);
        System.out.println("------------------------------------");
        System.out.println("Here is the invoice list");
        String header = String.format("|%-8s|%10s|", "ID", "DATE");
        System.out.println(header);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).output();
        }
    }

    public void searchInvoice() {
        if (list.isEmpty()) {
            System.out.println("The list of invoice is empty. Please add a new invoice!");
            return;
        }

        String id;
        Invoice x;

        id = Validation.getID("Input invoice id (IVXXXXXX): ", "The format of code is IVXXXXXX (X stands for a digit)", "^[I|i][V|v]\\d{6}$");
        x = searchInvoiceReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the invoice that you want to search");
            String header = String.format("|%-8s|%10s|", "ID", "DATE");
            System.out.println(header);
            x.output();
        }
    }

    public int searchInvoiceReturnPos(String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(code)) {
                return i;
            }
        }
        return -1;
    }

    public Invoice searchInvoiceReturnObj(String code) {
        for (Invoice o : list) {
            if (o.getId().equalsIgnoreCase(code)) {
                return o;
            }
        }
        return null;
    }

    public void updateInvoice() {
        if (list.isEmpty()) {
            System.out.println("The list of invoice is empty. Please add a new invoice!");
            return;
        }

        String id, newDate;
        Invoice x;
        id = Validation.getID("Input invoice id (IVXXXXXX): ", "The format of code is IVXXXXXX (X stands for a digit)", "^[I|i][V|v]\\d{6}$");
        x = searchInvoiceReturnObj(id);
        System.out.println("------------------------------------");
        if (x == null) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is the invoice before updating");
            String header = String.format("|%-8s|%10s|", "ID", "DATE");
            System.out.println(header);
            x.output();

            System.out.println("You are required to input a new date");
            newDate = Validation.getDateFormat("Input date (d/m/y): ", "Date must be follow format dd/mm/yyyy. Please input date again!", "dd/MM/yyyy", "01/01/2020", new Date());
            x.setDate(newDate);
            System.out.println("The invoice date is updated successfully! Here is the invoice after updating");
            System.out.println(header);
            x.output();
        }
    }

    public void removeInvoice() {
        if (list.isEmpty()) {
            System.out.println("The list of invoice is empty. Please add a new invoice!");
            return;
        }

        String id, choice;
        int pos;
        id = Validation.getID("Input invoice id (IVXXXXXX): ", "The format of code is IVXXXXXX (X stands for a digit)", "^[I|i][V|v]\\d{6}$");
        pos = searchInvoiceReturnPos(id);
        System.out.println("------------------------------------");
        if (pos == -1) {
            System.out.println("Not found!!!");
        } else {
            String header = String.format("|%-8s|%10s|", "ID", "DATE");
            System.out.println(header);
            list.get(pos).output();
            choice = Validation.getTwoOption("\nAre you sure you want to delete this invoice? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.remove(pos);
                System.out.println("The selected invoice is removed successfully!");
            }
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Invoice checkDuplicateOrderId(String id) {

        for (Invoice invoice : list) {
            if (invoice.getOrder() != null) {
                if (invoice.getOrder().getId().equalsIgnoreCase(id)) {
                    return invoice;
                }
            }
        }
        return null;
    }
}
