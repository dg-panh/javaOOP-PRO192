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
public class Fraction {
    public int numerator, denominato;

    public Fraction() {
        numerator = 0;
        denominato = 1;
    }

    public Fraction(int numerator, int denominato) {
        this.numerator = numerator;
        this.denominato = denominato;
    }
    
    public void inputFraction() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Numerator: ");
        numerator = sc.nextInt();
        System.out.println("Input Denominato: ");
        denominato = sc.nextInt();
    }

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominato=" + denominato + '}';
    }
    
    public void printFraction() {
        System.out.println("Fraction: " + numerator + " / " + denominato);
    }
    
    public Fraction addTwoFraction(int numerator, int denominato) {
        int tmp1 = this.numerator * denominato + this.denominato * numerator;
        int tmp2 = this.denominato * denominato;
        
        Fraction result = new Fraction(tmp1, tmp2);
        return result;
    }
    
    public Fraction subTwoFraction(int numerator, int denominato) {
        int tmp1 = this.numerator * denominato - this.denominato * numerator;
        int tmp2 = this.denominato * denominato;
        
        Fraction result = new Fraction(tmp1, tmp2);
        return result;
    }
    
    public Fraction multiplyTwoFraction(int numerator, int denominato) {
        int tmp1 = this.numerator * numerator;
        int tmp2 = this.denominato * denominato;
        Fraction result = new Fraction(tmp1, tmp2);
        return result;
    }
    
    public Fraction divideTwoFraction(int numerator, int denominato) {
        int tmp1 = this.numerator * denominato;
        int tmp2 = this.denominato * numerator;
        Fraction result = new Fraction(tmp1, tmp2);
        return result;
    }
    
}
