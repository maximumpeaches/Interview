package com.company.leetcode.p735;

public class Solution {
    private static final class Asteroid {
        private int size;
        private Asteroid next;
        private Asteroid prev;
        private Asteroid(int size) {
            this.size = size;
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        Asteroid prev = null;
        Asteroid head = null;
        for (int i = 0; i < asteroids.length; i++) {
            Asteroid curr = new Asteroid(asteroids[i]);
            if (i == 0) {
                prev = curr;
                head = curr;
            } else {
                prev.next = curr;
                curr.prev = prev;
                prev = curr;
            }
        }

        Asteroid curr = head;
        while (curr.next != null) {
            if (curr.size > 0) {
                if (curr.next.size < 0) {
                    int balance = curr.size + curr.next.size;
                    if (balance > 0) {
                        curr.next.next.prev = curr;
                        curr.next = curr.next.next;
                    } else if (balance < 0) {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                        curr = curr.next;
                    } else {
                        if (curr.prev == null && curr.next.next == null) {
                            return new int[0];
                        } else if (curr.prev == null) {
                            curr.next.next.prev = null;
                            curr = curr.next.next;
                        } else if (curr.next.next == null) {
                            curr.prev.next = null;
                            curr = curr.prev;
                        } else {
                            curr.prev.next = curr.next.next;
                            curr.next.next.prev = curr.prev;
                            curr = curr.prev;
                        }
                    }
                } else {
                    curr = curr.next;
                }

            } else { // curr is negative
                if (curr.prev == null || curr.prev.size < 0) {
                    curr = curr.next;
                } else {
                    int balance = curr.size + curr.next.size;
                    if (balance > 0) {
                        curr.prev.next = curr.next;
                        curr = curr.prev;
                    } else if (balance < 0) {

                    }
                }
            }
        }
        return null;
    }
}
