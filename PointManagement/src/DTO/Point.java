/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Point {
    private double x, y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point(Point P) {
        x = P.x;
        y = P.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getDistance(double x, double y) {
        double d = Math.sqrt((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y));
        return d;
    }
    
    public double getDistance(Point P) {
        double d = Math.sqrt((P.x - this.x) * (P.x - this.x) + (P.y - this.y) * (P.y - this.y));
        return d;
    }
}
