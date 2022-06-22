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
public class Plant extends LivingBeing {
    private int year;

    public Plant() {
        super();
        year = 0;
    }

    public Plant(int year, String name) {
        super(name);
        this.year = year;
    }

    @Override
    public String toString() {
        return name + "@" + year;
    }
    
    @Override
    public void grow() {
        System.out.println("by light");
    }
    
}
