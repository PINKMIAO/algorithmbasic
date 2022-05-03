package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/26 8:23
 */
public class A14_BobDie {
    public static double right(int row, int col, int k, int N, int M) {
        return (double) process(row, col, k, N, M) / Math.pow(4, k);
    }

    public static int process(int row, int col, int k, int N, int M) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        int ways = process(row + 1, col, k - 1, N, M);
        ways += process(row - 1, col, k - 1, N, M);
        ways += process(row, col + 1, k - 1, N, M);
        ways += process(row, col - 1, k - 1, N, M);
        return ways;
    }

    public static double dp1(int row, int col, int k, int n, int m) {
        long[][][] dp = new long[k + 1][n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[0][i][j] = 1;
            }
        }
        for (int rest = 1; rest <= k; rest++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    dp[rest][x][y] = pick(x + 1, y, rest - 1, n, m, dp);
                    dp[rest][x][y] += pick(x - 1, y, rest - 1, n, m, dp);
                    dp[rest][x][y] += pick(x, y + 1, rest - 1, n, m, dp);
                    dp[rest][x][y] += pick(x, y - 1, rest - 1, n, m, dp);
                }
            }
        }
        return (double) dp[k][row][col] / Math.pow(4, k);
    }

    public static long pick(int r, int c, int k, int n, int m, long[][][] dp) {
        if (r < 0 || r == n || c < 0 || c == m) {
            return 0;
        }
        return dp[k][r][c];
    }

    public static void main(String[] args) {
        System.out.println(right(6, 6, 10, 50, 50));
        System.out.println(dp1(6, 6, 10, 50, 50));
    }
}
