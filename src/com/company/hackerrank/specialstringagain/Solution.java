package com.company.hackerrank.specialstringagain;

public class Solution {
    /*
    abcbaba
    7 a, b, c, b, a, b, a
    bcb, abcba, bab, aba
     */

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count = 0;
        for (int index = 0; index < s.length(); index++) {
            count += returnSpecialStringsSurroundingIndex(s, index);
            count += returnSpecialStringsSurroundingIndices(s, index, index + 1);
        }
        return count;
    }

    private static long returnSpecialStringsSurroundingIndex(String s, int index) {
        long count = 1; // always the current index is a palindrome because it is a single character, so start at 1
        int back = index - 1;
        if (back < 0) {
            return count;
        }
        char lookingFor = s.charAt(back);
        int front = index + 1;
        while (back >= 0 && front < s.length() && s.charAt(back) == lookingFor && s.charAt(front) == lookingFor) {
            count++;
            back--;
            front++;
        }
        return count;
    }

    private static long returnSpecialStringsSurroundingIndices(String s, int back, int front) {
        if (back < 0) {
            return 0;
        }
        long count = 0;
        char lookingFor = s.charAt(back);
        while (back >= 0 && front < s.length() && s.charAt(back) == lookingFor && s.charAt(front) == lookingFor) {
            count++;
            back++;
            front++;
        }
        return count;
    }
}
