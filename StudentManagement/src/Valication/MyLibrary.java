/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valication;

/**
 *
 * @author PC
 */
public class MyLibrary {
    //hàm này để kiểm tra 1 số bất kì có nằm giữa min và max hay k
    public static boolean isValidNumber(double num, double min, double max) throws Exception {
        if (num < min || num > max)
            throw new Exception();
        return true;
    }
}
