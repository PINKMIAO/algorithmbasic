package com.weekTrain.weekdp4;

/**
 * @author Baven
 * @date 2022/4/20 19:49
 */
public class A07_PalindromeSubswquence {
    public static int longest1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        return process(str, 0, str.length - 1);
    }

    public static int process(char[] str, int L, int R) {
        if (L == R) {
            return 1;
        } else if (L == R - 1) {
            return str[L] == str[R] ? 2 : 1;
        }
        int p1 = process(str, L + 1, R);
        int p2 = process(str, L, R - 1);
        int p3 = process(str, L + 1, R - 1);
        int p4 = str[L] == str[R] ? (2 + process(str, L + 1, R - 1)) : 0;

        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public static int longest2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[][] dp = new int[N][N];
        dp[N - 1][N - 1] = 1;
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                if (str[L] == str[R]) {
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longest2(s));
    }
}
