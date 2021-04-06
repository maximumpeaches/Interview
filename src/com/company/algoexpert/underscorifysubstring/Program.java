package com.company.algoexpert.underscorifysubstring;

public class Program {
    public static String underscorifySubstring(String s, String substring) {
        StringBuilder newString = new StringBuilder(s.length());
        for (int i = 0; i < s.length();) {

        }
        return "";
    }

    /*
    aaa
    012345678
    aaaaaaaxaaaaaa


    iterate through s and substring, compare each and if they are valid, then update result to startingIndex + length of substring

    if they are not valid then begin subroutine at next index, unless next index is past the result value

    end the loop when you've checked through where result is the startingIndex
     */

    // returns the index of the last substring in this segment
    private static int indexOfSubstring(String s, String substring, int startingIndex) {
        if (substring.length() + startingIndex > substring.length()) {
            return -1;
        }
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) != s.charAt(i)) {
                return -1;
            }
        }
        int lastIndexToCheck = substring.length() + startingIndex;
        startingIndex++;
        while (startingIndex <= s.length() - substring.length() && startingIndex <= lastIndexToCheck) {
            int i = startingIndex;
            while (i < substring.length() + startingIndex) {
                if (substring.charAt(i) != s.charAt(i)) {
                    break;
                }
                i++;
            }
            if (i == substring.length() + startingIndex) {
                lastIndexToCheck = startingIndex + substring.length();
            }
            startingIndex++;
        }
        return lastIndexToCheck;
    }
}
