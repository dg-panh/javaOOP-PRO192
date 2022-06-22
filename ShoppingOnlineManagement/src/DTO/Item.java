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
public class Item implements Comparable<Item>{
    private String id;
    private String name;
    private double price;
    private String status;

    public Item(String id, String name, double price, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void output() {
        System.out.printf("|%-8s|%-15s|%7.1f|%6s|\n", id, name, price, status);
    }

    @Override
    public int compareTo(Item o) {
        return id.compareToIgnoreCase(o.id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
