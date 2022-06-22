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
public class Campus {
    private String code;
    private String name;
    private String address;

    public Campus() {
    }

    public Campus(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    
    public void inputCampus() {
        System.out.println("CAMPUS");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input code: ");
        code = sc.nextLine();
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
    }
    
    public void outputCampus() {
        System.out.println("CAMPUS");
        System.out.printf("|Code: %8s|Name: %15s|Address: %20s|", code, name, address);
    }
}
