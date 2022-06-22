/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Student;

/**
 *
 * @author PC
 */
public class Tester {
    public static void main(String[] args) {
        Student x = new Student();//x gọi hàm Student()
        x.inputProfile(); //x gọi hàm inputProfile
        x.printProfile(); //x gọi hàm xuất
    }
}
