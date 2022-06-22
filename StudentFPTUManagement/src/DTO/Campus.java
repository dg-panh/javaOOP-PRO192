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
public class Campus implements Comparable<Campus>{
    private String code;
    private String name;
    private String address;

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
    
    public void output() {
        System.out.printf("|%-4s|%-15s|%20s|\n", code, name, address);
    }

    @Override
    public int compareTo(Campus o) {
        return code.compareToIgnoreCase(o.code);
    }
    
    
}
