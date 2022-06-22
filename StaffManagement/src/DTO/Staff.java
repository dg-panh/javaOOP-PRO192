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
public class Staff implements Comparable<Staff>{
    protected String id;
    protected String name;
    protected String gender;
    protected double basicSalary;
    protected Manager manager;

    public Staff() {
        id = "";
        name = "";
        gender = "";
        basicSalary = 0;
        manager = null;
    }

    public Staff(String id, String name, String gender, double basicSalary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
    }

    public Staff(String id, String name, String gender, double basicSalary, Manager manager) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.basicSalary = basicSalary;
        this.manager = manager;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    
    public void input(){
        id = Validation.getString("Input id: ", "Id mustn't empty or contains all whitespace characters. Please input id again!", 1, 6).toUpperCase();
        name = Validation.getString("Input name: ", "Name mustn't empty or contains all whitespace characters. Please input name again!", 1, 15).toUpperCase();       
        gender = Validation.getTwoOption("Input gender (male/female): ", "Gender must be male or female. Please input gender again!", "male", "female");        
        basicSalary = Validation.getADouble("Input salary: ", "Salary must be from 1 to 999999.9. Please input salary again!", 1, 999999.9);
    }
    
    public void output() { 
        System.out.printf("|%-6s|%-15s|%6s|%12.1f|%12s|\n", id, name, gender, basicSalary, "None");
//        if (manager != null) {
//            System.out.println("\nManager");
//            manager.outputManager();
//        }
    }

    @Override
    public int compareTo(Staff s) {
        return id.compareToIgnoreCase(s.id); 
    }
    
//    public Manager checkManager() {
//        if (this.getManager() != null) {
//            return this.getManager();
//        }
//        return null;
//    }

}
