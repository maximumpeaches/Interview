package com.company.leetcode.p1392;

public class Solution {
    /*
    012345
    ababab
     */
    public String longestPrefix(String s) {
        String longest = "";
        int longestLength = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int back = 0;
            int front = s.length() - 1 - i;
            int currentLength = 0;
            while (front < s.length() && s.charAt(back) == s.charAt(front)) {
                front++;
                back++;
                currentLength++;
            }
            if (front == s.length() && currentLength > longestLength) {
                longest = s.substring(0, back);
            }
        }
        return longest;
    }
}
