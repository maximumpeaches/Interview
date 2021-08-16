package com.company.leetcode.p505;

class Solution {
    /*

    0 0 1 0
    0 1 1 0
    0 0 1 0


    1 1 1
    1 0 1
    1 1 1


     */

    private int[][] maze;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int startY = start[0];
        int startX = start[1];
        this.maze = maze;
        maze[destination[0]][destination[1]] = 3; // destination in maze == 3 now
    }

    private int findShortestFromPosition(int x, int y) {
        if (maze[y][x] == 3) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        maze[y][x] = 2;

        int yPrime = y;
        int xPrime = x;
        int distance = 0;
        while (isInBounds(yPrime + 1, xPrime) && maze[yPrime + 1][xPrime] != 1) {
            yPrime++;
            distance++;
        }
        if (yPrime != y) { // didn't move
            if (maze[yPrime][xPrime] != 2) { // already visited this spot if == 2
                if (maze[yPrime][xPrime] == 3) {
                    result = Math.min(distance, result);
                } else {
                    int resultFromHere;
                    if (maze[yPrime][xPrime] < 0) {
                        resultFromHere = Math.abs(maze[yPrime][xPrime]);
                    } else {
                        resultFromHere = findShortestFromPosition(xPrime, yPrime);
                    }
                    if (resultFromHere != -1) {
                        result = Math.min(distance + resultFromHere, result);
                    }
                }
            }
        }
        yPrime = y;
        xPrime = x;
        distance = 0;
        while (isInBounds(yPrime - 1, xPrime) && maze[yPrime - 1][xPrime] != 1) {
            yPrime--;
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }

    private boolean isInBounds(int y, int x) {
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[0].length) {
            return false;
        }
        return true;
    }
}
