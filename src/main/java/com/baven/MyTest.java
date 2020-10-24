package com.baven;

public class MyTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,4,5,8,7,9,0,5,4,3,1};

        StringBuilder ans = new StringBuilder();

        int sum = 9;
        while (-1 < sum) {
            int len = 0;
            while (len < arr.length) {
                if (arr[len] == sum) {
                    ans.append(arr[len]);
                }
                len++;
            }
            sum--;
        }
        System.out.println(ans.toString());
    }
}
