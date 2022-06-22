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
public class Customer implements Comparable<Customer>{
    private String id;
    private String name;
    private String address;

    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void output() {
        System.out.printf("|%-5s|%-15s|%20s|\n", id, name, address);
    }

    @Override
    public int compareTo(Customer o) {
        return id.compareToIgnoreCase(o.id);
    }
}
