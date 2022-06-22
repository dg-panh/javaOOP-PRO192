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
public class Customer {
    private String id;
    private String name;
    private String address;

    public Customer() {
    }

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
    
    public void inputInfoCustomer() {
        System.out.println("CUSTOMER");
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id: ");
        id = sc.nextLine();
        System.out.println("Input name: ");
        name = sc.nextLine();
        System.out.println("Input address: ");
        address = sc.nextLine();
    }
    
    public void outputInfoCustomer() {
        System.out.println("CUSTOMER");
        System.out.printf("|Id: %8s|Name: %10s|Address: %20s|", id, name, address);
    }
}
