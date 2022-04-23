package com.baven.a1sort;

/**
 * 前缀树、字典树等
 */
public class TireTree {

    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            // 0    a
            // 1    b
            // 2    c
            // ..   ..
            // 25   z
            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new Node1();
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
            char[] chs = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

    }

    public static void main(String[] args) {
        String[] arr = createRandomStringArray(10, 3);
        printArr(arr);
        Trie1 trie1 = new Trie1();
        for (int i = 0; i < arr.length; i++) {
            trie1.insert(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println(trie1.search(arr[i]));
        }
    }

    // for test
    public static String createRandomString(int strLen) {
        char[] ans = new char[(int) (Math.random() * strLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            int value = (int) (Math.random() * 6);
            ans[i] = (char) (97 + value);
        }
        return String.valueOf(ans);
    }
    public static String[] createRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[arrLen];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = createRandomString(strLen);
        }
        return ans;
    }
    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
