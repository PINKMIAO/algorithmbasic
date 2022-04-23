package com.weekTrain.week2;

/**
 * @author Baven
 * @date 2022/3/31 12:40
 */
public class B08_PaperFolding {
    public static void getFolds(int N) {
        process(1, N, true);
    }

    public static void process(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        process(i + 1, N, true);
        System.out.print(down ? "凹" : "凸");
        process(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        getFolds(N);
    }
}
