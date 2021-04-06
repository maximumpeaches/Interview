package com.company.algoexpert.patternmatcher;

import java.util.*;

public class Program {
    public static String[] patternMatcher(String pattern, String s) {
        if (pattern.isEmpty()) {
            return new String[0];
        }
        List<String> result = helper(new HashMap<>(), pattern, s, 0, 0, new ArrayList<>());
        if (result.isEmpty()) {
            return new String[]{""};
        } else {
            if (result.size() == 1 && pattern.charAt(0) == 'x') {
                return new String[]{result.get(0), ""};
            }
            if (result.size() == 1 && pattern.charAt(0) == 'y') {
                return new String[]{"", result.get(0)};
            }
            if (pattern.charAt(0) == 'x') {
                return new String[]{result.get(0), result.get(1)};
            } else {
                return new String[]{result.get(1), result.get(0)};
            }
        }
    }

    private static List<String> helper(Map<Character, String> m, String pattern, String s, int positionInPattern,
                                       int positionInString, List<String> result) {
        if (positionInPattern == pattern.length()) {
            return result;
        } else if (positionInString >= s.length()) {
            return new ArrayList<>();
        }
        char currentCharInPattern = pattern.charAt(positionInPattern);
        if (m.containsKey(currentCharInPattern)) {
            String currentPattern = m.get(currentCharInPattern);
            // check if the pattern is in s
            if (positionInString + currentPattern.length() < s.length() + 1
                    && s.substring(positionInString, positionInString + currentPattern.length()).equals(currentPattern)) {
                // pattern is in s
                return helper(m, pattern, s, positionInPattern + 1, positionInString + currentPattern.length(), result);
            } else {
                return new ArrayList<>();
            }
        } else {
            for (int i = positionInString; i < s.length(); i++) {
                Map<Character, String> mCopy = new HashMap<>(m);
                String patternMatch = s.substring(positionInString, i + 1);
                mCopy.put(currentCharInPattern, patternMatch);
                List<String> resultCopy = new ArrayList<>(result);
                resultCopy.add(patternMatch);
                List<String> r = helper(mCopy, pattern, s, positionInPattern, positionInString, resultCopy);
                if (!r.isEmpty()) {
                    return r;
                }
            }
            return new ArrayList<>();
        }
    }
}
