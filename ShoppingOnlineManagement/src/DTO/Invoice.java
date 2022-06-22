/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Invoice implements Comparable<Invoice>{
    private String id;
    private String date;
    private Order order;

    public Invoice(String id, String date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void output() {
        System.out.printf("|%-8s|%10s|\n", id, date);
    }
    
    public void outputWOrder() {
        System.out.printf("|%-8s|%10s|", id, date);
        if (order != null) {
            System.out.printf("%8s|\n", order.getId());
        } else {
            System.out.printf("%8s|\n", "None");
        }
    }

    @Override
    public int compareTo(Invoice o) {
        return id.compareToIgnoreCase(o.id); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Order checkOrder() {
        if (this.getOrder() != null) {
            return this.getOrder();
        }
        return null;
    }
}
