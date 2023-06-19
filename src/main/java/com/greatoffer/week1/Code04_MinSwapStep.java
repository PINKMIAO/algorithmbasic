package com.greatoffer.week1;

/**
 * @author Baven
 * @date 2022/6/8 19:44
 */
public class Code04_MinSwapStep {

    public static int minSteps1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] str = s.toCharArray();
        int step1 = 0;
        int step2 = 0;
        int qi = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') {
                step1 += i - (qi++);
            } else if (str[i] == 'B') {
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);
    }

}
