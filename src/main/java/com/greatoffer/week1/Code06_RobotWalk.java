package com.greatoffer.week1;

/**
 * @author Baven
 * @date 2022/6/14 18:56
 */
public class Code06_RobotWalk {
    public static int ways(int N, int start, int aim, int K) {
        if (aim < 0 || aim > N || start < 0 || start > N || K < 1 || N < 2) {
            return 0;
        }
        return process(N, start, aim, K);
    }

    public static int process(int N, int cur, int aim, int rest) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process(N, 2, aim, rest - 1);
        }
        if (cur == N) {
            return process(N, N - 1, aim, rest - 1);
        }
        return process(N, cur + 1, aim, rest - 1) + process(N, cur - 1, aim, rest - 1);
    }

    public static int ways1(int N, int start, int aim, int K) {
        if (aim < 0 || aim > N || start < 0 || start > N || K < 1 || N < 2) {
            return 0;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process1(start, K, aim, N, dp);
    }

    public static int process1(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int result = 0;
        if (rest == 0) {
            result = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            result = process1(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            result = process1(N - 1, rest - 1, aim, N, dp);
        } else {
            result = process1(cur + 1, rest - 1, aim, N, dp) + process1(cur - 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ways(5, 2, 4, 6));
        System.out.println(ways1(5, 2, 4, 6));
    }
}
