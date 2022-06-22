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
public class Animal extends LivingBeing{
    private String gender;

    public Animal() {
        super();
        gender = "female";
    }

    public Animal(String gender, String name) {
        super(name);
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + "@" + gender;
    }
    
    @Override
    public void grow() {
        System.out.println("by food");
    }
    
}
