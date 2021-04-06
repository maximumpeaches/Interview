package com.company.leetcode.p1071;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
    This solution doesn't pass Leetcode because for this input:
    str1 = "ABABAB", str2 = "ABAB"
    it returns this:
    "ABAB"
    whereas Leetcode is looking for this
    Output: "AB"

    See readme.md for more description.
     */
    public String gcdOfStrings(String str1, String str2) {

        String gcd = "";
        for (int len = 1; len < str1.length() + 1; len++) {
            Set<String> strings = new HashSet<>();
            for (int i = 0; i < str1.length() - len; i++) {
                String s = str1.substring(i, i + len);
                strings.add(s);
            }

            // This is the optimized version where we check if for instance a string of length 2 matched before adding a string of length 3
//            for (int i = 0; i < str1.length(); i++) {
//                if (!matches.isEmpty()) {
//                    String s = str1.substring(i, i + len - 1);
//                    if (matches.contains(s)) {
//                        strings.add(s + str1.charAt(i + len - 1));
//                    }
//                    strings.add(s);
//                } else {
//                    String s = str1.substring(i, i + len);
//                    strings.add(s);
//                }
//            }

            Set<String> matches = findMatchingSubstrings(strings, str2, len);
            if (matches.isEmpty()) {
                return gcd;
            } else {
                for (String m : matches) {
                    gcd = m;
                    break;
                }
            }
        }

        return gcd;
    }

    private Set<String> findMatchingSubstrings(Set<String> candidates, String str2, int len) {

        Set<String> matches = new HashSet<>();

        for (int i = 0; i < str2.length() - len + 1; i++) {
            String s = str2.substring(i, i + len);
            if (candidates.contains(s)) {
                matches.add(s);
            }
        }

        return matches;
    }
}
