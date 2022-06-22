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
public class Student {
    //khai báo field
    String id;
    String name;
    
    //khai báo method
    //constructors: khi trong class k viết 1 hàm constructor nào thì khi run -> java sẽ tự viết 1 hàm như này
    //trong code mình thì k thấy nhưng khi compile ra file .class có
    //constructor khởi tạo giá trị ban đầu cho các field, nếu k có thì các field ở trạng thái undefine -> unsafe 
    //nếu cta viết 1 func khác để gán gtr cho các field thì java sẽ k cần thêm hàm sau zô
    public Student() {
        id = "";
        name = "";
    }
    //setter
    //getters
    
    //nhập thông tin sinh viên
    public void inputProfile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input id: ");
        id = sc.nextLine();
        System.out.print("Input name: ");
        sc = new Scanner(System.in);
        name = sc.nextLine();
    }
    
    public void printProfile() {
        System.out.println("Id: " + id);
        System.out.println("Name: " + name);
    }
}
