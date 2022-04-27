package com.weekTrain.weekdp4;

/**
 * @author Baven
 * @date 2022/4/26 9:02
 */
public class A15_KillMonster {
    public static double right(int N, int M, int K) {
        if (N < 1 || M < 1 || K < 1) {
            return 0;
        }
        long all = (long) Math.pow(M + 1, K);
        long kill = process(M, K, N);
        return (double) ((double) kill / (double) all);
    }

    public static long process(int M, int times, int hp) {
        if (times == 0) {
            return hp <= 0 ? 1 : 0;
        }
        if (hp <= 0) {
            return (long) Math.pow(M + 1, times);
        }
        int ways = 0;
        for (int i = 0; i <= M; i++) {
            ways += process(M, times - 1, hp - i);
        }
        return ways;
    }

    public static double dp1(int n, int m, int k) {
        long[][] dp = new long[k + 1][n + 1];
        dp[0][0] = 1;
        for (int times = 1; times <= k; times++) {
            dp[times][0] = (long) Math.pow(m + 1, times);
            for (int hp = 1; hp <= n; hp++) {
                long ways = 0;
                for (int i = 0; i <= m; i++) {
                    if (hp - i >= 0) {
                        ways += dp[times - 1][hp - i];
                    } else {
                        ways += (long) Math.pow(m + 1, times);
                    }
                }
                dp[times][hp] = ways;
            }
        }
        return (double) dp[k][n] / Math.pow(m + 1, k);
    }

    public static void main(String[] args) {
        System.out.println(right(20, 4, 7));
        System.out.println(dp1(20, 4, 7));
    }
}
