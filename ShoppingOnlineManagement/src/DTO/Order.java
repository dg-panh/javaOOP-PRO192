/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Order implements Comparable<Order>{
    private String id;
    private String orderDate;
    private String shipDate;
    private int totalOfQuantity;
    private Customer customer;

    public Order(String id, String orderDate, String shipDate) {
        this.id = id;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.totalOfQuantity = 0;
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

    public void setShipDate(String shipDate) {
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
    
    public void output() {
        System.out.printf("|%-8s|%10s|%10s|%8d|\n", id, orderDate, shipDate, totalOfQuantity);
    }
    
    public void outputWCustomer() {
        System.out.printf("|%-8s|%10s|%10s|%8d|", id, orderDate, shipDate, totalOfQuantity);
        if (customer != null) {
            System.out.printf("%8s|\n", customer.getId());
        } else {
            System.out.printf("%8s|\n", "None");
        }
    }

    @Override
    public int compareTo(Order o) {
        return id.compareToIgnoreCase(o.id); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean checkShipDate(String shipDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date date1 = formatter.parse(orderDate);
            Date date2 = formatter.parse(shipDate);
            
            if(date2.before(date1))
                throw new Exception();
            return true;
        } catch (ParseException e) {
            System.out.println(e);
            return false;
        } catch (Exception e) {
            System.out.println("The ship date cannot be before the order date.");
            return false;
        }
    }
    
    public Customer checkCustomer() {
        if (this.getCustomer() != null) {
            return this.getCustomer();
        }
        return null;
    }
}
