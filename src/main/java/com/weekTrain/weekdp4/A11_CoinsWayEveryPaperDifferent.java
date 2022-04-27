package com.weekTrain.weekdp4;

/**
 * @author Baven
 * @date 2022/4/25 9:15
 */
public class A11_CoinsWayEveryPaperDifferent {

    public static int coinWays(int[] arr, int aim) {
        if (arr == null || arr.length < 1 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(arr, index + 1, rest) + process(arr, index + 1, rest - arr[index]);
    }

    public static int dp(int[] arr, int aim) {
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest] + (rest - arr[index] >= 0 ? dp[index + 1][rest - arr[index]] : 0);
            }
        } // dp[index + 1][rest - arr[index]]
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 3, 4, 6, 4, 2, 6, 8, 7};
        int aim = 17;
        System.out.println(coinWays(arr, aim));
        System.out.println(dp(arr, aim));
    }
}
