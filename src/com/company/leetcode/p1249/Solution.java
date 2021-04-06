package com.company.leetcode.p1249;

public class Solution {
    /*
    (((())))(((

    )(())) -> 2

    if have zero opening braces, and come to a closing brace, then increment result

    (((()))()())

    ))((
     */
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int openingCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openingCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openingCount > 0) {
                    openingCount--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        int i = sb.length() - 1;
        while (openingCount > 0) {
            if (sb.charAt(i) == '(') {
                sb.delete(i, i + 1);
                openingCount--;
            }
            i--;
        }
        return sb.toString();
    }
}
