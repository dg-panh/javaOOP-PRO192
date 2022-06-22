/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
import util.Validation;

/**
 *
 * @author PC
 */
public class Pet implements Comparable<Pet> {

    private String id;
    private String name;
    private String birthday;
    private String gender;
    private Owner owner;

    public Pet() {
        id = "";
        name = "";
        birthday = "";
        gender = "";
        owner = null;
    }

    public Pet(String id, String name, String birthday, String gender) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Pet(String id, String name, String birthday, String gender, Owner owner) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.owner = owner;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void input() {
        id = Validation.getString("Input pet's id: ", "Pet's id mustn't empty or contains all whitespace characters. Please input pet's id again!", 1, 6).toUpperCase();
        name = Validation.getString("Input pet's name: ", "Pet's name mustn't empty or contains all whitespace characters. Please input pet's name again!", 1, 15).toUpperCase();
        birthday = Validation.getDateFormat("Input pet's birthday (d/m/y): ", "Pet's birthday must be follow format dd/mm/yyyy. Please input pet's birthday again!", "dd/MM/yyyy", "01/01/1900", new Date());
        gender = Validation.getTwoOption("Input pet's gender (male/female): ", "Pet's gender must be male or female. Please input pet's gender again!", "male", "female");
    }

    public void output() {
        System.out.printf("|%-6s|%-15s|%s|%6s|", id, name, birthday, gender); //chua co valid do dai cua id va name
        if (owner != null) {
            System.out.printf("%6s|\n", owner.getId());
        } else System.out.printf("%6s|\n", "None");
    }

    @Override
    public int compareTo(Pet o) {
        return id.compareToIgnoreCase(o.getId());
    }
    
    public Owner checkOwner(String id) {
        if (this.getOwner() != null) {
            return this.getOwner();
        }
        return null;
    }

}
