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
public class Course {
    private String code;
    private String name;
    private int credits;

    public Course() {
    }

    public Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public void inputCourse() {
        System.out.println("COURSE");
        Scanner sc = new Scanner(System.in);
        System.out.print("Input code: ");
        code = sc.nextLine();
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input credits: ");
        credits = sc.nextInt();
    }
    
    public void outputCourse() {
        System.out.println("COURSE");
        System.out.printf("|Code: %8s|Name: %20s|Credits: %2s|", code, name, credits);
    }
}
