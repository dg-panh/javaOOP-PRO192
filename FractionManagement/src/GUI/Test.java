/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Fraction;

/**
 *
 * @author PC
 */
public class Test {
    public static void main(String[] args) {
        Fraction A = new Fraction(1, 2);
        Fraction B = new Fraction(2, 5);
        A.printFraction();
        Fraction C = A.addTwoFraction(B.numerator, B.denominato);
        C.printFraction();
        C = A.subTwoFraction(B.numerator, B.denominato);
        C.printFraction();
        C = B.multiplyTwoFraction(A.numerator, A.denominato);
        C.printFraction();
        C = B.divideTwoFraction(A.numerator, A.denominato);
        C.printFraction();
    }
}
