/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Customer;
import DTO.CustomerList;
import DTO.Invoice;
import DTO.InvoiceList;
import DTO.ItemList;
import DTO.Order;
import DTO.OrderItemList;
import DTO.OrderList;
import UI.Menu;
import util.Validation;

/**
 *
 * @author PC
 */
public class ShoppingOnlineManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu("Shopping Online Management System");
        menu.addNewOption("1. Manage customer list");
        menu.addNewOption("2. Manage order list");
        menu.addNewOption("3. Manage item list");
        menu.addNewOption("4. Manage invoice list");
        menu.addNewOption("5. Manage customer orders by customer id");
        menu.addNewOption("6. Manage order item");
        menu.addNewOption("7. Manage order and invoice");
        menu.addNewOption("8. Quit");

        CustomerList cList = new CustomerList();
        OrderList oList = new OrderList();
        ItemList iList = new ItemList();
        InvoiceList rList = new InvoiceList();
        OrderItemList oTList = new OrderItemList(oList, iList);

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to manage customer list");
                    manageCustomerList(cList);
                    break;
                case 2:
                    System.out.println("You are required to manage order list");
                    manageOrderList(oList);
                    break;
                case 3:
                    System.out.println("You are required to manage item list");
                    manageItemList(iList);
                    break;
                case 4:
                    System.out.println("You are required to manage invoice list");
                    manageInvoiceList(rList);
                    break;
                case 5:
                    System.out.println("You are required to manage customer orders by customer id");
                    manageOrderCustomer(cList, oList);
                    break;
                case 6:
                    System.out.println("You are required to manage order item");
                    manageOrderItem(oTList, iList, oList);
                    break;
                case 7:
                    System.out.println("You are required to manage order and invoice");
                    manageOrderInvoice(oList, rList);
                    break;
                case 8:
                    System.out.println("Bye bye, see you next time!");
                    break;
            }
        } while (choice != 8);
    }

    public static void manageCustomerList(CustomerList list) {
        Menu menuPet = new Menu("Customer List Management");
        menuPet.addNewOption("1. Add a new customer profile");
        menuPet.addNewOption("2. Search a customer profile by id");
        menuPet.addNewOption("3. Update a customer profile by id");
        menuPet.addNewOption("4. Remove a customer profile by id");
        menuPet.addNewOption("5. Print the customer list ascending by code");
        menuPet.addNewOption("6. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new customer profile");
                    list.addCustomer();
                    break;
                case 2:
                    System.out.println("You are required to search a customer profile by id");
                    list.searchCustomer();
                    break;
                case 3:
                    System.out.println("You are required to update a customer profile by id");
                    list.updateCustomer();
                    break;
                case 4:
                    System.out.println("You are required to remove a customer profile by id");
                    list.removeCustomer();
                    break;
                case 5:
                    System.out.println("You are required to print the customer list ascending by code");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageOrderList(OrderList list) {
        Menu menu = new Menu("Order List Management");
        menu.addNewOption("1. Add a new order information");
        menu.addNewOption("2. Search a order by id");
        menu.addNewOption("3. Update a order by id");
        menu.addNewOption("4. Remove a order by id");
        menu.addNewOption("5. Print the order list ascending by id");
        menu.addNewOption("6. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new order information");
                    list.addOrder();
                    break;
                case 2:
                    System.out.println("You are required to search a order by id");
                    list.searchOrder();
                    break;
                case 3:
                    System.out.println("You are required to update a order by id");
                    list.updateOrder();
                    break;
                case 4:
                    System.out.println("You are required to remove a order by id");
                    list.removeOrder();
                    break;
                case 5:
                    System.out.println("You are required to print the order list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageItemList(ItemList list) {
        Menu menu = new Menu("Item List Management");
        menu.addNewOption("1. Add a new item information");
        menu.addNewOption("2. Search a item by id");
        menu.addNewOption("3. Update a item by id");
        menu.addNewOption("4. Remove a item by id");
        menu.addNewOption("5. Print the item list ascending by id");
        menu.addNewOption("6. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new item information");
                    list.addItem();
                    break;
                case 2:
                    System.out.println("You are required to search a item by id");
                    list.searchItem();
                    break;
                case 3:
                    System.out.println("You are required to update a item by id");
                    list.updateItem();
                    break;
                case 4:
                    System.out.println("You are required to remove a item by id");
                    list.removeItem();
                    break;
                case 5:
                    System.out.println("You are required to print the item list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageInvoiceList(InvoiceList list) {
        Menu menu = new Menu("Invoice List Management");
        menu.addNewOption("1. Add a new invoice information");
        menu.addNewOption("2. Search a invoice by id");
        menu.addNewOption("3. Update a invoice by id");
        menu.addNewOption("4. Remove a invoice by id");
        menu.addNewOption("5. Print the invoice list ascending by id");
        menu.addNewOption("6. Quit");

        int choice;
        do {
            menu.printMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new invoice information");
                    list.addInvoice();
                    break;
                case 2:
                    System.out.println("You are required to search a invoice by id");
                    list.searchInvoice();
                    break;
                case 3:
                    System.out.println("You are required to update a invoice by id");
                    list.updateInvoice();
                    break;
                case 4:
                    System.out.println("You are required to remove a invoice by id");
                    list.removeInvoice();
                    break;
                case 5:
                    System.out.println("You are required to print the invoice list ascending by id");
                    list.displayAll();
                    break;
                case 6:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 6);
    }

    public static void manageOrderCustomer(CustomerList cList, OrderList oList) {
        if (cList.isEmpty() || oList.isEmpty()) {
            if (cList.isEmpty()) {
                System.out.println("The list of customer is empty. Please add a new customer!");
            }
            if (oList.isEmpty()) {
                System.out.println("The list of order is empty. Please add a new order!");
            }
            return;
        }

        String oId, cId;
        Customer c;
        Order o;
        String choice = "";

        Menu menu = new Menu("Update customer information for order");
        menu.addNewOption("1. Update");
        menu.addNewOption("2. Print a list of order by customer id");
        menu.addNewOption("3. Quit");
        int input;

        do {
            menu.printMenu();
            input = menu.getChoice();
            switch (input) {
                case 1:
                    do {
                        cId = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
                        c = cList.searchCustomerReturnObj(cId);
                        if (c == null) {
                            System.out.println("Not found this customer in customer list. Please input customer's id again!");
                        } else {
                            System.out.println("Here is the customer have ID: " + cId);
                            String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
                            System.out.println(header);
                            c.output();

                            do {
                                oId = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
                                o = oList.searchOrderReturnObj(oId);
                                if (o == null) {
                                    System.out.println("Not found this order in order list. Please input order id again!");
                                } else {
                                    System.out.println("Here is the order have ID: " + oId);
                                    header = String.format("|%-8s|%10s|%10s|%8s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY", "CUSTOMER");
                                    System.out.println(header);
                                    o.outputWCustomer();

                                    if (o.checkCustomer() != null) {
                                        choice = Validation.getTwoOption("\nThis order already has an customer, are you sure you still want to update the customer for it? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                    } else {
                                        choice = Validation.getTwoOption("Are you sure you want to update the customer " + cId + " for order " + oId + "? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                    }
                                    switch (choice) {
                                        case "y":
                                            o.setCustomer(c);
                                            System.out.println("After update, here is the order have ID: " + oId);
                                            System.out.println(header);
                                            o.outputWCustomer();
                                            break;
                                        case "n":
                                            break;
                                    }
                                    System.out.println("");
                                    choice = Validation.getTwoOption("Do you want to update this customer information for another order? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                                }
                            } while (o == null || choice.equalsIgnoreCase("y"));
                            choice = Validation.getTwoOption("Do you want to continue updating customer information for order? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        }
                    } while (c == null || choice.equalsIgnoreCase("y"));
                    break;
                case 2:
                    Customer x;
                    cId = Validation.getID("Input customer id (CXXXX): ", "The format of code is CXXXX (X stands for a digit)", "^[C|c]\\d{4}$");
                    x = cList.searchCustomerReturnObj(cId);
                    System.out.println("------------------------------------");
                    if (x == null) {
                        System.out.println("Not found!!!");
                    } else {
                        System.out.println("CUSTOMER");
                        String header = String.format("|%-5s|%-15s|%20s|", "ID", "NAME", "ADDRESS");
                        System.out.println(header);
                        x.output();

                        System.out.println("------------------------------------");
                        System.out.println("Order list belongs to customer " + cId);
                        header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
                        System.out.println(header);
                        oList.printListOrderByCustomer(cId);
                    }
                    break;
                case 3:
                    break;
            }
        } while (input != 3);

    }

    public static void manageOrderItem(OrderItemList list,ItemList iList, OrderList oList) {
        if (iList.isEmpty() || oList.isEmpty()) {
            if (iList.isEmpty()) {
                System.out.println("The list of item is empty. Please add a new item!");
            }
            if (oList.isEmpty()) {
                System.out.println("The list of order is empty. Please add a new order!");
            }
            return;
        }

        Menu menuPet = new Menu("Order Item List Management");
        menuPet.addNewOption("1. Add a new order item");
        menuPet.addNewOption("2. Print item(s) in the order by order id");
        menuPet.addNewOption("3. Remove a item by order id");
        menuPet.addNewOption("4. Quit");

        int choice;
        do {
            menuPet.printMenu();
            choice = menuPet.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("You are required to add a new order item");
                    list.addOrderItem();
                    break;
                case 2:
                    System.out.println("You are required to search order item by order id");
                    list.searchItemOfOrder();
                    break;
                case 3:
                    System.out.println("You are required to remove a item by order id");
                    list.removeOrderItem();
                    break;
                case 4:
                    System.out.println(" ");
                    break;
            }
        } while (choice != 4);
    }

    public static void manageOrderInvoice(OrderList oList, InvoiceList iList) {
        if (oList.isEmpty() || iList.isEmpty()) {
            if (oList.isEmpty()) {
                System.out.println("The list of order is empty. Please add a new order!");
            }
            if (iList.isEmpty()) {
                System.out.println("The list of invoice is empty. Please add a new invoice!");
            }
            return;
        }

        String iId, oId;
        Order o;
        Invoice i;
        String choice = "";

        do {
            oId = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
            o = oList.searchOrderReturnObj(oId);
            if (o == null) {
                System.out.println("Not found this order in order list. Please input order id again!");
            } else {
                if ((iList.checkDuplicateOrderId(oId)) != null) {
                    choice = Validation.getTwoOption("This order already has an invoice, are you sure you still want to update for it? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                    if (choice.equalsIgnoreCase("y")) {
                        iList.checkDuplicateOrderId(oId).setOrder(null);
                    } else {
                        break;
                    }
                }

                System.out.println("Here is the order have ID: " + oId);
                String header = String.format("|%-8s|%10s|%10s|%8s|", "ID", "ORDER DATE", "SHIP DATE", "QUANTITY");
                System.out.println(header);
                o.output();

                do {
                    iId = Validation.getID("Input invoice id (IVXXXXXX): ", "The format of code is IVXXXXXX (X stands for a digit)", "^[I|i][V|v]\\d{6}$");
                    i = iList.searchInvoiceReturnObj(iId);
                    if (i == null) {
                        System.out.println("Not found this invoice in invoice list. Please input invoice id again!");
                    } else {
                        System.out.println("Here is the invoice have ID: " + iId);
                        header = String.format("|%-8s|%10s|%8s|", "ID", "DATE", "ORDER");
                        System.out.println(header);
                        i.outputWOrder();

                        if (i.checkOrder() != null) {
                            choice = Validation.getTwoOption("\nThis invoice already has an order, are you sure you still want to update the order for it? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        } else {
                            choice = Validation.getTwoOption("Are you sure you want to update the order " + oId + " for invoice " + iId + "? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
                        }
                        switch (choice) {
                            case "y":
                                i.setOrder(o);
                                System.out.println("After update, here is the invoice have ID: " + iId);
                                System.out.println(header);
                                i.outputWOrder();
                                break;
                            case "n":
                                break;
                        }
                        System.out.println("");
                    }
                } while (i == null);
                choice = Validation.getTwoOption("Do you want to continue updating order information for invoice? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            }
        } while (o == null || choice.equalsIgnoreCase("y"));
    }

}
