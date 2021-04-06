package com.company.leetcode.p1041;

public class Solution {

    /*
    XXXXX
    XXXXX
    XXXXX
    XXXXX
     */
    private enum Direction {
        N, S, E, W
    }
    public boolean isRobotBounded(String instructions) {
        int up = 0;
        int left = 0;
        Direction facing = Direction.N;
        Direction endDirection = Direction.S;
        while (endDirection != Direction.N) {
            for (char c : instructions.toCharArray()) {
                switch (c) {
                    case 'R':
                        switch (facing) {
                            case N:
                                facing = Direction.E;
                                break;
                            case E:
                                facing = Direction.S;
                                break;
                            case S:
                                facing = Direction.W;
                                break;
                            case W:
                                facing = Direction.N;
                                break;
                        }
                        break;
                    case 'L':
                        switch (facing) {
                            case N:
                                facing = Direction.W;
                                break;
                            case E:
                                facing = Direction.N;
                                break;
                            case S:
                                facing = Direction.E;
                                break;
                            case W:
                                facing = Direction.S;
                                break;
                        }
                        break;
                    case 'G':
                        switch (facing) {
                            case N:
                                up++;
                                break;
                            case E:
                                left--;
                                break;
                            case S:
                                up--;
                                break;
                            case W:
                                left++;
                                break;
                        }
                        break;
                }
            }
            endDirection = facing;
        }

        if (up != 0 || left != 0) {
            return false;
        } else {
            return true;
        }
    }
}
