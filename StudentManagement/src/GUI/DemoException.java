/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Student;
import Valication.MyLibrary;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class DemoException {

    public void Test(Student stu) {
        stu.printProfile();
    }

    public void Test2() {
        String fileName = "C://data.txt";
        FileReader f = null;
        try {
            f = new FileReader(fileName);
            //TODO: doc ND

        } catch (FileNotFoundException e) {
            System.out.println("file don't have");
        } finally {
            //f.close();
        }
    }

    public void Test3() {
        try {
            double min = 1;
            double max = 100;

            Scanner sc = new Scanner(System.in);
            System.out.println("Input Quantity: ");
            double num = sc.nextDouble();
            MyLibrary.isValidNumber(num, min, max);
        } catch (Exception e) {
            System.out.println("Quantity is valid!");
        }

    }

    public static void main(String[] args) {
//        int x = 2;
//        int y = 0;
//        System.out.println(x / y);

//        int[] a = {1, 2, 3, 4, 5};
//        for (int i = 0; i < 10; i++) {
//            System.out.println(a[i]);
//        }
        DemoException obj = new DemoException();
        Student stu = null;
        obj.Test(stu);
    }
}
