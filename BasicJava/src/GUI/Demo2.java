/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Demo2 {

    public static void main(String[] args) {
        int a;
        float b;
        boolean c;
        String s;

        Scanner sc = new Scanner(System.in);
        System.out.print("Input a: ");
        a = sc.nextInt();
        System.out.print("Input b: ");
        b = sc.nextFloat();
        System.out.println("Input c: ");
        c = sc.nextBoolean();
        System.out.println("Input s: ");
        sc = new Scanner(System.in);
        s = sc.nextLine();

        System.out.println(a + "," + b + "," + c + "," + s);
        if (s.equals("SE")) 
            System.out.println("After: " + s.toLowerCase());
        
        String[] listName = new String[3];
        for (int i = 0; i < 3; i++) {
            sc = new Scanner(System.in);
            System.out.println("Input name: ");
            listName[i] = sc.nextLine();
        }
        
        System.out.println(listName[1].toUpperCase());
    }

}
