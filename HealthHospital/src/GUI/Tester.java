/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Log;
import DTO.Owner;
import DTO.Pet;
import DTO.Service;

/**
 *
 * @author PC
 */
public class Tester {

    public static void main(String[] args) {
        Pet p1 = new Pet();
        p1.input();
        Pet p2 = new Pet();
        p2.input();
        Owner owner = new Owner();
        owner.input();
        p1.setOwner(owner);
        p2.setOwner(owner);
        
        Service s1 = new Service("1", "TIA LONG", 700);
        Service s2 = new Service("2", "CAT MONG", 400);
        
        Log x = new Log(p1, s1);
        Log y = new Log(p1, s2);
        Log z = new Log(p2, s1);
        
        x.output();
        y.output();
        z.output();
        
        p1.output();
        p2.output();
        
        
        
    }
}
