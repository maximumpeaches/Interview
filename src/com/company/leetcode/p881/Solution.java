package com.company.leetcode.p881;

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        if (people == null || people.length == 0) {
            return 0;
        }
        Arrays.sort(people);

        int biggestIdx = people.length - 1;
        int smallestIdx = 0;

        int numBoats = 0;

        while (biggestIdx > smallestIdx) {
            if (people[biggestIdx] + people[smallestIdx] <= limit) {
                numBoats++;
                biggestIdx--;
                smallestIdx++;
            } else {
                numBoats++;
                biggestIdx--;
            }
        }

        // if these indices are equal it means we still have one person who needs to get in the boat
        // if the biggestIdx is strictly less than smallestIdx, it means everyone has boarded the boats.
        if (biggestIdx == smallestIdx) {
            numBoats++;
        }

        return numBoats;
    }
}
