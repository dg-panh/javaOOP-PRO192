/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Book {
    String id, title, publisher;
    
    //default constructor
    public Book() {
        id = "";
        title = "";
        publisher = "";
    }

    //constructor with parameter
    public Book(String id, String title, String publisher) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
    }
    
    public void inputBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input id: ");
        id = sc.nextLine();
        System.out.print("Input title: ");
        title = sc.nextLine();
        System.out.print("Input publisher: ");
        publisher = sc.nextLine();
    }
    
    public void outputBook() {
        System.out.printf("|%7s|%-20s|%-20s|", id, title, publisher);
    }
    
}
