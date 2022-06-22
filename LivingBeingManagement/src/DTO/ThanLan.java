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
public class ThanLan extends Animal implements Food {

    @Override
    public void eatBug() {
        System.out.println("the luoi");
        System.out.println("bo vao mieng");
        System.out.println("nhai");
    }
    
}
