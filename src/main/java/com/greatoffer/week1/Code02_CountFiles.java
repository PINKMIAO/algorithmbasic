package com.greatoffer.week1;

import java.io.File;
import java.util.Stack;

/**
 * @author Baven
 * @date 2022/6/8 19:23
 */
public class Code02_CountFiles {

    public static int getFileNumber(String folderPath) {
        File root = new File(folderPath);
        if (!root.isDirectory() && !root.isFile()) {
            return 0;
        }
        if (root.isFile()) {
            return 1;
        }
        Stack<File> stack = new Stack<>();
        stack.add(root);
        int files = 0;
        while (!stack.isEmpty()) {
            File folder = stack.pop();
            for (File next : folder.listFiles()) {
                if (next.isFile()) {
                    files++;
                }
                if (next.isDirectory()) {
                    stack.push(next);
                }
            }
        }
        return files;
    }

    public static void main(String[] args) {
        String path = "/Users/w/Desktop/";
        System.out.println();
    }
}
