/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author PC
 */
public class Demo {
    
    public static void main(String[] args) {
        System.out.println("Demo 1");
        String s1 = "Va the la yeu"; //chỉ dc làm với String
        System.out.println(s1);
        String s2 = new String ("Chua yeu"); //cách chuẩn mực
        System.out.println(s2);
        
        int[] a = new int [3];
        a[0] = 1; 
        a[1] = 20;
        a[2] = 45;
        //int[] a = {1, 20, 45};
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        for (int v : a) {
            System.out.println(v);
        }
        
        int x = -1;
        System.out.println("-1 << 1: " + (x << 1));
        System.out.println("-1 >> 1: " + (x >> 1));
        System.out.println("-1 >>> 1: " + (x >>> 1));
        System.out.println("3 | 4: " + (3 | 4));
        System.out.println("3 & 4: " + (3 & 4));
        System.out.println("3 ^ 4: " + (3 ^ 4));
        
        String S = "Hello";
        boolean result = S instanceof String;
        System.out.println("Hello is an instance of String: " + result);
        
    }
    
}
