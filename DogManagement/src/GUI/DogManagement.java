/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Dog;
import DTO.DogList;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DogManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 0;
        DogList list = new DogList();
        do {
            System.out.println("1. Add new dog");
            System.out.println("2. Display");
            System.out.println("3. Update dog");
            System.out.println("4. Remove dog");
            Scanner sc = new Scanner(System.in);
            System.out.println("Input choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Dog d = new Dog("1", "lulu", 2);
                    if(list.addDog(d))
                        System.out.println("added");
                    else System.out.println("fail");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        } while (choice <= 4);
    }
    
}
