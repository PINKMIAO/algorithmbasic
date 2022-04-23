package com.weekTrain.weekdp4.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Baven
 * @date 2022/4/17 19:57
 */
public class PrintAllSubsquences {
    public static void sub(String s) {
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        process(str, 0, set, "");
        for (String an : set) {
            System.out.println(an);
        }
    }

    public static void process(char[] str, int index, Set<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process(str, index + 1, ans, no);
        String yes = path + str[index];
        process(str, index + 1, ans, yes);
    }

    public static void main(String[] args) {
        sub("abcc");
    }
}
