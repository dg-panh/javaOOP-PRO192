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
public class Student {
    private  String id;
    private String name;
    private String address;
    private String gender;
    private Campus campus;

    public Student() {
    }

    public Student(String id, String name, String address, String gender, Campus campus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.campus = campus;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
    public void inputStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT");
        System.out.print("Input id: ");
        id = sc.nextLine();
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
        System.out.print("Input gender: ");
        gender = sc.nextLine();
    }
    
    public void outputStudent() {
        System.out.println("STUDENT");
        System.out.printf("|Id: %8s|Name: %10s|Address: %20s|Gender: %6s|", id, name, address, gender);
        if (campus != null) 
            System.out.printf("Campus: %15s|", campus.getName());
    }
}
