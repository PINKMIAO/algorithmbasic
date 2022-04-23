package com.weekTrain.week1;

/**
 * @author Baven
 * @date 2022/3/28 15:29
 */
public class D01_TireTree {
    public static void main(String[] args) {
        String[] arr = generateRandomStringArray(10, 6);
        printStringArray(arr);
    }

    public static class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }

    public static class Tire {
        private Node root;

        public Tire() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            Node node = root;
            node.pass++;
            int path = 0;
            for (char c : word.toCharArray()) {
                path = c - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node();

                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public int search(String word) {
            if (word == null) {
                return 0;
            }
            int path = 0;
            Node node = root;
            for (char c : word.toCharArray()) {
                path = c - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;

        }
        public int searchTire(String word) {
            if (word == null) {
                return 0;
            }
            Node node = root;
            int path = 0;
            for (char c : word.toCharArray()) {
                path = c - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }
        public void delete() {

        }
    }




    public static String generateRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }
    public static void printStringArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
