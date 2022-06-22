/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.FileDAO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DogList {
    ArrayList<Dog> list;
    final String filename = "data.txt";
    
    public DogList() {
        try {
            list = FileDAO.loadData(filename);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public boolean addDog (Dog d) {
        list.add(d);
        try {
            FileDAO.saveData(filename, list);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
