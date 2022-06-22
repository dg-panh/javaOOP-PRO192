/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Tester {
    public static void main(String[] args) {
        DogList ds = new DogList();
//        ds.addDog(new Dog(20, "a"));
//        ds.addDog(new Dog(10, "b"));
//        ds.addDog(new Dog(30, "c"));
//        ds.addDog(new Dog(10, "tester"));
//        ds.displayAll();

        ds.testWriteFile();
        ds.testReadFile();
    }
}
