package com.company;

import java.util.Scanner;
public class Quadrate {
    long numberQuadrate;
    int x1, x2, x3, x4;
    int y1, y2, y3, y4;
    double side1, side2, side3, side4;
    double diagonal1, diagonal2;
    double perimeter;
    boolean rhombus;

    private Object quadrate;

    Scanner scan = new Scanner(System.in);

    public double getNumQuadrate() {
        return numberQuadrate;
    }


    public void setX1(int x1) {
        this.x1 = x1;
    }
    public int getX1() {
        return (int) x1;
    }
    public void setY1(int y1) {
        this.y1 = y1;
    }
    public int getY1() {
        return (int) y1;
    }

    // 2
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public int getX2() {
        return (int) x2;
    }
    public void setY2(int y2) {
        this.y2 = y2;
    }
    public int getY2() {
        return (int) y2;
    }

    // 3
    public void setX3(int x3) {
        this.x3 = x3;
    }
    public int getX3() {
        return (int) x3;
    }
    public void setY3(int y3) {
        this.y3 = y3;
    }
    public int getY3() {
        return (int) y3;
    }

    // 4
    public void setX4(int x4) {
        this.x4 = x4;
    }
    public int getX4() {
        return (int) x4;
    }
    public void setY4(int y4) {
        this.y4 = y4;
    }
    public int getY4() {
        return (int) y4;
    }
}
