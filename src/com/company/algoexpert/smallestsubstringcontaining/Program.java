package com.company.algoexpert.smallestsubstringcontaining;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static String smallestSubstringContaining(String bigString, String smallString) {
        int back = 0;
        int front = 0;
        String smallestSubstring = null;
        Map<Character, Integer> smallCounts = countCharacters(smallString);
        int lettersCounted = 0;

        Map<Character, Integer> bigCounts = new HashMap<>();

//        char firstChar = bigString.charAt(0);
//        if (smallCounts.containsKey(firstChar)) {
//            lettersCounted++;
//            bigCounts.put(firstChar, 1);
//        }
//        if (lettersCounted == smallString.length()) {
//            // special case where first character contains the smallString
//            return smallString;
//        }

        // loop invariant: bigCounts contains the characters of smallCounts that are within the bounds of back and front
        // lettersCounted is the number of letters of smallCounts that have been counted up to their maximum for each
        // smallestSubstring equals the smallest string seen so far that contains all the letters within smallString
        while (front < bigString.length()) {
            char currentChar = bigString.charAt(front);
            if (smallCounts.containsKey(currentChar)) {
                if (bigCounts.containsKey(currentChar)) {
                    bigCounts.put(currentChar, bigCounts.get(currentChar) + 1);
                } else {
                    bigCounts.put(currentChar, 1);
                }
                if (bigCounts.get(currentChar) <= smallCounts.get(currentChar)) {
                    lettersCounted++;
                }
            }

            if (lettersCounted == smallString.length()) {
                // try to shrink the string to the smallest substring that still contains all the characters in smallString
                char backChar = bigString.charAt(back);
                while (!smallCounts.containsKey(backChar) || smallCounts.get(backChar) < bigCounts.get(backChar)) {
                    if (smallCounts.containsKey(backChar)) {
                        bigCounts.put(backChar, bigCounts.get(backChar) - 1);
                    }
                    back++;
                    backChar = bigString.charAt(back);
                }
                String localSmallestSubstring = bigString.substring(back, front + 1);
                if (smallestSubstring == null || smallestSubstring.length() > localSmallestSubstring.length()) {
                    smallestSubstring = localSmallestSubstring;
                }
                back = back + 1;
                front = back;
                bigCounts = new HashMap<>();
                lettersCounted = 0;
            } else {
                front++;
            }
        }
        return smallestSubstring == null ? "" : smallestSubstring;
    }

    private static Map<Character, Integer> countCharacters(String smallString) {
        Map<Character, Integer> smallStringCounts = new HashMap<>(smallString.length());
        for (char c : smallString.toCharArray()) {
            if (!smallStringCounts.containsKey(c)) {
                smallStringCounts.put(c, 0);
            }
            smallStringCounts.put(c, smallStringCounts.get(c) + 1);
        }
        return smallStringCounts;
    }
}
