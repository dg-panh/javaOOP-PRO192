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
public class Owner implements Comparable<Owner>{

    private String id;
    private String name;
    private String address;

    public Owner() {
    }

    public Owner(String id, String name, String address) {
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

    public void input() {
        id = Validation.getString("Input owner's id: ", "Owner's id mustn't empty or contains all whitespace characters. Please input owner's id again!", 1, 6).toUpperCase();
        name = Validation.getString("Input owner's name: ", "Owner's name mustn't empty or contains all whitespace characters. Please input owner's name again!", 1, 15).toUpperCase();
        address = Validation.getString("Input owner's address: ", "Owner's address mustn't empty or contains all whitespace characters. Please input owner's address again!", 1, 20);
    }

    public void output() {
        System.out.printf("|%-6s|%-15s|%20s|\n", id, name, address);
    }

    @Override
    public int compareTo(Owner o) {
        return id.compareToIgnoreCase(o.getId());
    }
}
