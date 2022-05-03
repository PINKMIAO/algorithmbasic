package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/27 9:01
 */
public class A16_MinCoinsNoLimit {

    public static int right(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int zhangs = 0; zhangs * arr[index] <= rest; zhangs++) {
            int next = process(arr, index + 1, rest - zhangs * arr[index]);
            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + zhangs);
            }
        }
        return ans;
    }

    public static int dp1(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhangs = 0; zhangs * arr[index] <= rest; zhangs++) {
                    int next = dp[index + 1][rest - zhangs * arr[index]];
                    if (next != Integer.MAX_VALUE) {
                        ans = Math.min(ans, next + zhangs);
                    }
                }
                dp[index][rest] = ans;
            }
        }

        return dp[0][aim];
    }

    public static int dp2(int[] arr, int aim) {
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int i = 1; i <= aim; i++) {
            dp[N][i] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >=0 && dp[index][rest - arr[index]] != Integer.MAX_VALUE) {
                    dp[index][rest] = Math.min(dp[index][rest] , dp[index][rest - arr[index]] + 1);
                }
            }
        }

        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8};
        int aim = 16;
        System.out.println(right(arr, aim));
        System.out.println(dp1(arr, aim));
        System.out.println(dp2(arr, aim));
    }
}
