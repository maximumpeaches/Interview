package com.company.leetcode.p981;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {
    @Test
    public void t() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        assertEquals("bar", timeMap.get("foo", 1));         // return "bar"
        assertEquals("bar", timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to
        // "foo" at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
        assertEquals("bar2", timeMap.get("foo", 4));         // return "bar2"
        assertEquals("bar2", timeMap.get("foo", 5));         // return "bar2"
    }
}