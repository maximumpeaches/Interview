package com.company.leetcode.p2;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        System.out.println(solution("cyclec"));
    }
    public static int solution(String S) {
        // we can solve this problem in O(n) time and O(1) space by using a sliding window approach
        // we will keep track of characters in a Set as we see them
        // a Set is useful because we can check in O(1) time if an element exists in it
        Set<Character> seenCharacters = new HashSet<>();
        int splitCount = 1; // we know that S will be at least of length 1
        for (char c : S.toCharArray()) {
            if (seenCharacters.contains(c)) {
                splitCount += 1;
                seenCharacters = new HashSet<>();
            } else {
                seenCharacters.add(c);
            }
        }

        return splitCount;
    }
}
