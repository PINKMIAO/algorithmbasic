package com.weekTrain.weekdp4.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baven
 * @date 2022/4/18 11:01
 */
public class PrintAllPermutations {
    public static void permutation1(String s) {
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        process(str, 0, ans);
        for (String an : ans) {
            System.out.println(an);
        }
    }

    public static void process(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
            return;
        }
        for (int i = index; i < str.length; i++) {
            swag(str, i, index);
            process(str, index + 1, ans);
            swag(str, i, index);
        }
    }

    public static void swag(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        permutation1("abc");
    }
}
