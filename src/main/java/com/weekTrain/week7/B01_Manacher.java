package com.weekTrain.week7;

/**
 * @author Baven
 * @date 2022/5/3 15:01
 */
public class B01_Manacher {
    public static int right(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[C * 2 - i], R - i) : 1;
            while (i - pArr[i] > 0 && i + pArr[i] < str.length) {
                if (str[i - pArr[i]] == str[i + pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static char[] manacherString(String s) {
        char[] str = s.toCharArray();
        char[] res = new char[str.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : str[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "asdjgievvlforwerrewrovvdpo";
        System.out.println(right(s));
    }
}
