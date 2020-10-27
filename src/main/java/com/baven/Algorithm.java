package com.baven;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    public static void main(String[] args) {
        System.out.println("version 4.0");
    }


}
class Solution {
    // baoli jiefa
    public int[] solution(int[] arr){
        int len = arr.length;
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < len; i++) {
            int temp = arr[i];
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (arr[i] > arr[j]){
                    count++;
                }
            }
            ans.add(count);
        }

        ans.toArray();
        return null;
    }
}
