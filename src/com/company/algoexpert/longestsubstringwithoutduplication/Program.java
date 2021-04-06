package com.company.algoexpert.longestsubstringwithoutduplication;

import java.util.HashMap;
import java.util.Map;

public class Program {

    /*

    characterCount contains the count of letters between back and front pointers, inclusive

    clementisacap


     */
    public static String longestSubstringWithoutDuplication(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Map<Character, Integer> characterCount = new HashMap<>();
        int back = 0;
        int front = 0;

        String longestSubstring = "";

        while (front < s.length()) {
            char frontChar = s.charAt(front);
            if (!characterCount.containsKey(frontChar)) {
                characterCount.put(frontChar, 0);
            }
            while (characterCount.get(frontChar) == 1) {
                char backChar = s.charAt(back);
                characterCount.put(backChar, 0);
                back++;
            }
            characterCount.put(frontChar, 1);
            if (front - back + 1 > longestSubstring.length()) {
                longestSubstring = s.substring(back, front + 1);
            }
            front++;
        }

        return longestSubstring;
    }
}
