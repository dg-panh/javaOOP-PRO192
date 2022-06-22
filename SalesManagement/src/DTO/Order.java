/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Order {
    private String id;
    private String orderDate;
    private String shipDate;
    private int totalOfQuantity;
    private Customer customer;

    public Order() {
    }

    public Order(String id, String orderDate, String shipDate, int totalOfQuantity, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.totalOfQuantity = totalOfQuantity;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShopDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getTotalOfQuantity() {
        return totalOfQuantity;
    }

    public void setTotalOfQuantity(int totalOfQuantity) {
        this.totalOfQuantity = totalOfQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void inputOrder() {
        System.out.println("ORDER");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id: ");
        id = sc.nextLine();
        System.out.println("Input order date: ");
        orderDate = sc.nextLine();
        System.out.println("Input ship date: ");
        shipDate = sc.nextLine();
        System.out.println("Input ");
    }
}
