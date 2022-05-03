package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/19 19:34
 */
public class A03_Knapsack {
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w.length != v.length || w.length == 0 || bag < 0) {
            return -1;
        }
        int i = process1(w, v, bag, 0, 0);
        int i1 = process2(w, v, bag, 0);
        System.out.println(i + " " + i1);
        return 1;
    }

    public static int process1(int[] w, int[] v, int bag, int index, int ans) {
        if (bag < 0) {
            return -1;
        }
        if (bag == 0 || index == w.length) {
            return ans;
        }
        int p1 = process1(w, v, bag, index + 1, ans);

        int p2 = process1(w, v, bag - w[index], index + 1, ans + v[index]);
        return Math.max(p1, p2);
    }

    public static int process2(int[] w, int[] v, int bag, int index) {
        if (bag < 0) {
            return -1;
        }
        if (index == w.length) {
            return 0;
        }
        int p1 = process2(w, v, bag, index + 1);
        int p2 = 0;
        int next = process2(w, v, bag - w[index], index + 1);
        if (next != -1) {
            p2 = v[index] + next;
        }
        return Math.max(p1, p2);
    }

    public static int dp(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }


    public static void main(String[] args) {
        int[] weight = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        maxValue(weight, values, bag);
        System.out.println(dp(weight, values, bag));
    }
}
