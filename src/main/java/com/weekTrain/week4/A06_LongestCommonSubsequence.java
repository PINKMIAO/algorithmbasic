package com.weekTrain.week4;

/**
 * @author Baven
 * @date 2022/4/20 18:02
 */
public class A06_LongestCommonSubsequence {

    public int longestCommonSubsequence(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        return process1(str1, str2, str1.length - 1, str2.length - 1);
    }

    public int process1(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        } else if (i == 0) {
            // 判断 i=0 说明i的那一侧字符串只剩下一个了，即使符合也只有一个匹配，下同
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i, j - 1);
            }
        } else if (j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            } else {
                return process1(str1, str2, i - 1, j);
            }
        } else {
            /*可能一 左边不可能，右边可能
             * 可能二 左边可能，右边不可能
             * 可能三 左右都有可能，但是，不能单单的把i, j 不动的传入，所以做个判断*/
            int p1 = process1(str1, str2, i - 1, j);
            int p2 = process1(str1, str2, i, j - 1);
            int p3 = str1[i] == str2[j] ? (1 + process1(str1, str2, i - 1, j - 1)) : 0;
            return Math.max(p1, Math.max(p2, p3));
        }
    }

    public static int longest(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int n1 = str1.length;
        int n2 = str2.length;
        int[][] dp = new int[n1][n2];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < n1; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }
        for (int i = 1; i < n2; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }
        return dp[n1 - 1][n2 - 1];
    }

    public static void main(String[] args) {
        A06_LongestCommonSubsequence s = new A06_LongestCommonSubsequence();
        String s1 = "dsvswq1244";
        String s2 = "dvces1234";
        StringBuilder ss1 = new StringBuilder(s1);
        System.out.println(ss1.reverse().toString());
        System.out.println(s.longestCommonSubsequence(s1, s2));
        System.out.println(longest(s1, s2));

    }
}
