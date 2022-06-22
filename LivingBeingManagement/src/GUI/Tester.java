/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Animal;
import DTO.Food;
import DTO.LivingBeing;
import DTO.Plant;
import DTO.ThanLan;
import DTO.Venus;

/**
 *
 * @author PC
 */
public class Tester {
    public static void main(String[] args) {
        LivingBeing x = new Plant(1950, "co thu");
        x.useWater();
        x.grow();
        
        LivingBeing y = new Animal("male", "hi");
        y.useWater();
        y.grow();
        
        //Food la cha nuoi -> hop le
        Food z = new Venus();
        z.eatBug();
        Food m = new ThanLan();
        z.eatBug();
        
        Venus n = new Venus();
        n.useWater();
        n.eatBug();
    }
}
