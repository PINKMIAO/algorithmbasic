package com.baven;

public class MyTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,4,5,8,7,9,0,5,4,3,1};
        StringBuilder str = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i : arr) {
            str.append(i);
        }

        int sum = 56;
        while (46 < sum) {
            int len1 = 0;
            while (len1 < str.length()) {
                if ((str.charAt(len1)) == sum) {
                    ans.append(str.charAt(len1));

                }
                len1++;
            }
            sum--;
        }
        System.out.println(ans.toString());

    }
}
