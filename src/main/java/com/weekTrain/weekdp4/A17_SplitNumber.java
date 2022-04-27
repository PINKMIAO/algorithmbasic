package com.weekTrain.weekdp4;

import jdk.nashorn.internal.ir.SplitReturn;

/**
 * @author Baven
 * @date 2022/4/27 12:28
 */
public class A17_SplitNumber {
    public static int right(int n) {
        return process(1, n);
    }
    public static int process(int pre, int rest) {
        if (rest == 0) {
            return 1;
        }
        if (pre > rest) {
            return 0;
        }
        int ans = 0;
        for (int first = pre; first <= rest; first++) {
            ans += process(first, rest - first);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(right(n));
    }
}
