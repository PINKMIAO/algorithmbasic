package com.weekTrain.weekdp4;

/**
 * @author Baven
 * @date 2022/4/19 22:43
 */
public class A04_ConvertToLetterString {
    public static int numbers(String s) {
        if (s == null || s.length() == 0) {
            return -0;
        }
        return process(s.toCharArray(), 0);
    }

    public static int process(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        int ways = process(str, index + 1);
        if (index + 1 < str.length && (str[index] - '0') * 10 + (str[index + 1] - '0') < 27) {
            ways += process(str, index + 2);
        }
        return ways;
    }

    public static int dp1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] != '0') {
                int ways = dp[i + 1];
                if (i + 1 < str.length && (str[i] - '0') * 10 + (str[i + 1] - '0') < 27) {
                    ways += dp[i + 2];
                }
                dp[i] = ways;
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        String s = "13452113";
        System.out.println(numbers(s));
        System.out.println(dp1(s));
    }
}
