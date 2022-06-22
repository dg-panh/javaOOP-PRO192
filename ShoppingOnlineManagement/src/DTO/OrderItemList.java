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
public class OrderItemList {

    ArrayList<OrderItem> list;
    OrderList listO;
    ItemList listI;

    public OrderItemList(OrderList oList, ItemList iList) {
        this.listO = oList;
        this.listI = iList;
        list = new ArrayList<>();
    }

    public void addOrderItem() {
        String idO, idI, choice;
        Order o;
        Item it;

        do {
            idO = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
            o = listO.searchOrderReturnObj(idO);
            if (o == null) {
                System.out.println("Not found this order in list. Please input id again!");
            }
        } while (o == null);

        do {
            do {
                idI = Validation.getID("Input item id (ITXXXXXX): ", "The format of code is ITXXXXXX (X stands for a digit)", "^[I|i][T|t]\\d{6}$");
                it = listI.searchItemReturnObj(idI);
                if (it == null) {
                    System.out.println("Not found this item in item list. Please input item id again!");
                }
            } while (it == null);

            list.add(new OrderItem(o, it));
            list.get(list.size() - 1).getOrder().setTotalOfQuantity(o.getTotalOfQuantity() + 1);
            list.get(list.size() - 1).getItem().setStatus("1");
            int i = list.size();
            list.get(i - 1).setIndex(i);
            System.out.println("A item is added successfully!");
            choice = Validation.getTwoOption("Do you want to continue adding item for this order? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
        } while (choice.equalsIgnoreCase("y"));

    }

    public void searchItemOfOrder() {
        if (list.isEmpty()) {
            System.out.println("The order item list is empty. Nothing to print");
            return;
        }

        String id;
        ArrayList<OrderItem> listSearchOrder;

        id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
        listSearchOrder = searchOrderItemReturnList(id);
        Collections.sort(listSearchOrder);
        System.out.println("------------------------------------");
        if (listSearchOrder.isEmpty()) {
            System.out.println("Not found!!!");
        } else {
            System.out.println("Here is/are item(s) of order has ID: " + id);
            String header = String.format("|%5s|%-8s|%-15s|%7s|%6s|", " ", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            for (int i = 0; i < listSearchOrder.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearchOrder.get(i).getItem().output();
            }
        }
    }

    public ArrayList<OrderItem> searchOrderItemReturnList(String id) {
        ArrayList<OrderItem> listSearch = new ArrayList<>();
        for (OrderItem oI : list) {
            if (oI.getOrder().getId().equalsIgnoreCase(id)) {
                listSearch.add(oI);
            }
        }
        return listSearch;
    }

    public OrderItem searchOrderItemtByOrderID(int index) {
        for (OrderItem oT : list) {
            if (oT.getIndex() == index) {
                return oT;
            }
        }
        return null;
    }
    
    public int searchOrderItemReturnPos(int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIndex() == index) {
                return i;
            }
        }
        return -1;
    }

    public void removeOrderItem() {
        if (list.isEmpty()) {
            System.out.println("The list of order item is empty. Please add a new order item!");
            return;
        }

        String id, choice;
        int pos, tmpIndex;
        OrderItem t;
        ArrayList<OrderItem> listSearch;

        id = Validation.getID("Input order id (ODXXXXXX): ", "The format of code is ODXXXXXX (X stands for a digit)", "^[O|o][D|d]\\d{6}$");
        listSearch = searchOrderItemReturnList(id);
        Collections.sort(listSearch);
        System.out.println("------------------------------------");
        if (listSearch.isEmpty()) {
            System.out.println("Not found!!!");
        } else {

            System.out.println("Here is/are item(s) of order has ID: " + id);
            String header = String.format("|%5s|%-8s|%-15s|%7s|%6s|", " ", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            for (int i = 0; i < listSearch.size(); i++) {
                System.out.printf("|%5d", (i + 1));
                listSearch.get(i).getItem().output();
            }

            int maxOption = listSearch.size();
            String inputMsg = "Input the index you want to remove (1.." + maxOption + "): ";
            String errorMsg = "You are required to choose the index 1.." + maxOption + ". Please input the index again!";
            pos = Validation.getAnInteger(inputMsg, errorMsg, 1, maxOption);
            tmpIndex = listSearch.get(pos - 1).getIndex(); //bien tmp luu index 

            System.out.println("Here is a item that you want to remove");
            header = String.format("|%-8s|%-15s|%7s|%6s|", "ID", "NAME", "PRICE", "STATUS");
            System.out.println(header);
            t = searchOrderItemtByOrderID(tmpIndex);
            t.getItem().output();

            choice = Validation.getTwoOption("\nAre you sure you want to delete this item? (y/n): ", "Your choice must be y or n. Please input your choice again!", "y", "n");
            if (choice.equalsIgnoreCase("y")) {
                list.get(searchOrderItemReturnPos(tmpIndex)).getOrder().setTotalOfQuantity(t.getOrder().getTotalOfQuantity() - 1);
                list.remove(t);
                System.out.println("The selected item is removed successfully!");
            }
        }
    }

}
