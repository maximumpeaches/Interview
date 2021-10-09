package com.company.leetcode.p833;

class Solution {
    /*
    have a ptr x in the string, starts at 0
    if indices[i] > x, then copy every index of s to result
    if sources[i] doesn't match then keep x where it is
    if sources[i] does match then increment x the length of sources[i]
    if reach end of string and x less than s.length() then copy everything from x to s.length() to result

    abctyuwx
    indices = [2]
    sources = ["ct"]
    targets = ["eee"]

    */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder(s.length());
        int x = 0;
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            while (index > x) {
                result.append(s.charAt(x));
                x++;
            }
            String source = sources[i];
            boolean matches = true;
            if (x + source.length() - 1 >= s.length()) {
                matches = false;
            } else {

                for (int j = 0; j < source.length(); j++) {
                    if (s.charAt(x + j) != source.charAt(j)) {
                        matches = false;
                        break;
                    }
                }
            }
            if (matches) {
                String target = targets[i];
                result.append(target);
                x += source.length();
            }
        }
        while (x < s.length()) {
            result.append(s.charAt(x));
            x++;
        }
        return result.toString();
    }
}