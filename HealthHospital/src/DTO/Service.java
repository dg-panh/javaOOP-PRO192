/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import util.Validation;

/**
 *
 * @author PC
 */
public class Service implements Comparable<Service> {

    private String id;
    private String name;
    private double price;

    public Service() {
    }

    public Service(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public void input() {
        id = Validation.getString("Input service's id: ", "Service's id mustn't empty or contains all whitespace characters. Please input service's id again!", 1, 6).toUpperCase();
        name = Validation.getString("Input service's name: ", "Service's name mustn't empty or contains all whitespace characters. Please input service's name again!", 1, 15).toUpperCase();
        price = Validation.getADouble("Input service's price: ", "Service's price must be from 1 to 999999.9. Please input service's price again!", 1, 999999.9);
    }

    public void output() {
        System.out.printf("|%-6s|%-15s|%7.1f|\n", id, name, price);
    }

    @Override
    public int compareTo(Service s) {
        return id.compareToIgnoreCase(s.getId());
    }
    
    
}
