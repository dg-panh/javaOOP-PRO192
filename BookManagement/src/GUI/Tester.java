/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Book;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Tester {
    public static void main(String[] args) {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Book b = null;
        do {
            System.out.println("1. Input book");
            System.out.println("2. Output book");
            System.out.println("3. Exit");
            System.out.print("Input a option: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: 
                    b = new Book();
                    b.inputBook();
                    break;
                case 2: 
                    if (b != null)
                        b.outputBook();
                    else
                        System.out.println("No information!");
                    break;
                case 3:
                    return;
            }
            System.out.println("");
        } while (choice != 3);
    }
}
