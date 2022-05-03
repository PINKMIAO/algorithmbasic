package com.weekTrain.week7;

import java.util.concurrent.TimeUnit;

/**
 * @author Baven
 * @date 2022/5/3 14:39
 */
public class A01_FibonacciProblem {
    public static long f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    public static long f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int N = m.length;
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = product(res, t);
            }
            t = product(t, t);
        }
        return res;
    }

    public static int[][] product(int[][] a, int[][] b) {
        int N = a.length;
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int c = 0; c < N; c++) {
                    res[i][j] += a[i][c] * b[c][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // 1 1 2 3 5 8 13
        System.out.println(f1(20));
        System.out.println(f3(20));
    }
}
