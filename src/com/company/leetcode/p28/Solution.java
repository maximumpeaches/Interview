package com.company.leetcode.p28;

public class Solution {

    /*
    String text = "aefoaefcdaefcdaed";
                      0 1 2 3 4 5 6 7
    String pattern = "a b a b a c a b";
                      0 0 1 2 3
     */
    public int strStr(String text, String pattern) {
        if (pattern.isEmpty()) {
            return 0;
        }

        int[] j = preprocess(pattern);

        int firstIndex = -1;

        for (int i = 0; i < text.length(); i++) {

        }


        return firstIndex;
    }

    private int[] preprocess(String pattern) {
        int[] j = new int[pattern.length()];
        j[0] = 0;
        int k = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
                k = j[k] - 1;
            }
            if (pattern.charAt(i) == pattern.charAt(k)) {
                k++;
            }
            j[i] = k;
        }
        return j;
    }
}
