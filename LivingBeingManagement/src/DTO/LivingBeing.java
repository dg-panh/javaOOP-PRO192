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
public abstract class LivingBeing {
    String name;

    public LivingBeing() {
    }

    public LivingBeing(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void useWater() {
        System.out.println("used water");
    }
    
    public abstract void grow();
}
