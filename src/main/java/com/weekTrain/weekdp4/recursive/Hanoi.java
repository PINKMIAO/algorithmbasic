package com.weekTrain.weekdp4.recursive;

/**
 * @author Baven
 * @date 2022/4/17 19:22
 */
public class Hanoi {

    public static void hanoi(int i) {
        leftToRight(i);
        System.out.println("======================");
        func(i, "left", "right", "mid");
    }

    public static void leftToRight(int index) {
        if (index == 1) {
            System.out.println("1 left to right");
            return;
        }
        leftToMid(index - 1);
        System.out.println(index + " left to mid");
        midToRight(index - 1);
    }

    public static void midToRight(int index) {
        if (index == 1) {
            System.out.println("1 mid to right");
            return;
        }
        midToLeft(index - 1);
        System.out.println(index + " mid to right");
        leftToRight(index - 1);
    }

    public static void leftToMid(int index) {
        if (index == 1) {
            System.out.println("1 left to mid");
            return;
        }
        leftToRight(index - 1);
        System.out.println(index + " left to mid");
        rightToMid(index - 1);
    }

    public static void midToLeft(int index) {
        if (index == 1) {
            System.out.println("1 mid to left");
            return;
        }
        midToRight(index - 1);
        System.out.println(index + " mid to left");
        rightToLeft(index - 1);
    }

    public static void rightToMid(int index) {
        if (index == 1) {
            System.out.println("1 right to mid");
            return;
        }
        rightToLeft(index - 1);
        System.out.println(index + " right to mid");
        leftToMid(index - 1);
    }

    public static void rightToLeft(int index) {
        if (index == 1) {
            System.out.println("1 right to left");
            return;
        }
        rightToMid(index - 1);
        System.out.println(index + " right to left");
        midToLeft(index - 1);
    }

    public static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("1 " + from + " to " + to);
            return;
        }
        func(n - 1, from, other, to);
        System.out.println(n + " " + from + " to " + to);
        func(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
