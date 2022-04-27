package com.weekTrain.weekdp4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Baven
 * @date 2022/4/25 18:18
 */
public class A13_CoinsWaySameValueSamepaper {
    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] coins, int[] zhangs) {
            this.coins = coins;
            this.zhangs = zhangs;
        }
    }

    public static Info getInfo(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i : arr) {
            if (!counts.containsKey(i)) {
                counts.put(i, 1);
            } else {
                counts.put(i, counts.get(i) + 1);
            }
        }
        int N = counts.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }

    public static int coinWays(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        return process(info.coins, info.zhangs, 0, aim);
    }

    public static int process(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
            ways += process(coins, zhangs, index + 1, rest - zhang * coins[index]);
        }
        return ways;
    }

    public static int dp(int[] arr, int aim) {
        Info info = getInfo(arr);
        int N = info.coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * info.coins[index] <= rest && zhang <= info.zhangs[index]; zhang++) {
                    ways += dp[index + 1][rest - zhang * info.coins[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int dp1(int[] arr, int aim) {
        Info info = getInfo(arr);
        int N = info.coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = dp[index + 1][rest];
                if (rest - info.coins[index] >= 0) {
                    ways += dp[index][rest - info.coins[index]];
                }
                if (rest - (info.zhangs[index] + 1) * info.coins[index] >= 0) {
                    ways -= dp[index + 1][rest - (info.zhangs[index] + 1) * info.coins[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 3, 4, 6, 4, 2, 6, 8, 3};
        int aim = 17;
        System.out.println(coinWays(arr, aim));
        System.out.println(dp(arr, aim));
        System.out.println(dp1(arr, aim));
    }
}
