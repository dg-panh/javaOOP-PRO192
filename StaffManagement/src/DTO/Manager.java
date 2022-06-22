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
public class Manager extends Staff{
    private double bonusSalary;

    public Manager() {
        super();
        bonusSalary = 0;
    }

    public Manager(String id, String name, String gender, double basicSalary, double bonusSalary) {
        super(id, name, gender, basicSalary);
        this.bonusSalary = bonusSalary;
    }

    public double getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(double bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

/*    public void inputManager() {
        input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input bonus salary: ");
        bonusSalary = sc.nextDouble();
    }
    
    public void outputManager() {
        System.out.println("Manager");
        output();
        System.out.printf("Bonus salary: %.2f|\n", bonusSalary);
    } */

    @Override
    public void output() {
        System.out.printf("|%-6s|%-15s|%6s|%12.1f|%12.1f|\n", id, name, gender, basicSalary, bonusSalary);
    }

    @Override
    public void input() {
        super.input(); //To change body of generated methods, choose Tools | Templates.
        Scanner sc = new Scanner(System.in);
        System.out.print("Input bonus salary: ");
        bonusSalary = sc.nextDouble();
    }
    
    
}
