package com.company.leetcode.p981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TimeMap {

    private static final class Values {
        private TreeMap<Integer, String> valueByTime = new TreeMap<>();

        private Values(String value, int timestamp) {
            this.valueByTime.put(timestamp, value);
        }

        private void set(String value, int timestamp) {
            this.valueByTime.put(timestamp, value);
        }

        private String getFloor(int timestamp) {
            return this.valueByTime.floorEntry(timestamp).getValue();
        }
    }

    private final Map<String, Values> valuesByKey = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (this.valuesByKey.get(key) == null) {
            this.valuesByKey.put(key, new Values(value, timestamp));
        } else {
            this.valuesByKey.get(key).set(value, timestamp);
        }
    }

    public String get(String key, int timestamp) {
        String value = this.valuesByKey.get(key) == null ? null : this.valuesByKey.get(key).getFloor(timestamp);
        return value == null ? "" : value;
    }
}
