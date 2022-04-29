package com.weekTrain.weekdp4;

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

    public static int dp1(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int pre = n-1; pre >= 1; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                int ans = 0;
                for (int first = pre; first <= rest; first++) {
                    ans += dp[first][rest - first];
                }
                dp[pre][rest] = ans;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(right(n));
        System.out.println(dp1(n));
    }
}
