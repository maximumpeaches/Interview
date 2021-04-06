package com.company.leetcode.p97;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    private static final class Key {
        int i1;
        int i2;
        int i3;

        @Override
        public boolean equals(Object o) {
            Key other = (Key) o;
            return i1 == other.i1 && i2 == other.i2 && i3 == other.i3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2, i3);
        }
    }

    String s1;
    String s2;
    String s3;
    Map<Key, Boolean> cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.cache = new HashMap<>();

        return doesMatch(0, 0, 0);
    }

    private boolean doesMatch(int i1, int i2, int i3) {
        Key key = new Key();
        key.i1 = i1;
        key.i2 = i2;
        key.i3 = i3;
        if (this.cache.containsKey(key)) {
            return this.cache.get(key);
        }
        if (i3 == s3.length()) {
            return true;
        }
        boolean result;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
                // both s1 and s2 match at this char
                result = doesMatch(i1 + 1, i2, i3 + 1) || doesMatch(i1, i2 + 1, i3 + 1);
            } else {
                // only s1 matches at this char
                result = doesMatch(i1 + 1, i2, i3 + 1);
            }
        } else if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            result = doesMatch(i1, i2 + 1, i3 + 1);
        } else {
            result = false;
        }
        this.cache.put(key, result);
        return result;
    }
}
