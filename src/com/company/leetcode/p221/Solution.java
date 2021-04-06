package com.company.leetcode.p221;

import java.util.*;

public class Solution {
    static class Square {
        int topRow;
        int bottomRow;
        int leftCol;
        int rightCol;
        Square(int topRow, int bottomRow, int leftCol, int rightCol) {
            this.topRow = topRow;
            this.bottomRow = bottomRow;
            this.leftCol = leftCol;
            this.rightCol = rightCol;
        }
        @Override
        public boolean equals(Object o) {
            Square other = (Square) o;
            if (other.topRow == this.topRow && other.bottomRow == this.bottomRow && other.leftCol == this.leftCol && other.rightCol == this.rightCol) {
                return true;
            } else {
                return false;
            }
        }
        @Override
        public int hashCode() {
            return Objects.hash(this.topRow, this.bottomRow, this.rightCol, this.leftCol);
        }
    }

    char[][] matrix;
    int numRows;
    int numCols;
    Map<Square, Integer> cache = new HashMap<>();
    public int maximalSquare(char[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        this.matrix = matrix;

        List<Square> singleSquares = new ArrayList<>();
        // first find all the squares with just one 1 in them
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                if (matrix[rowIdx][colIdx] == '1') {
                    Square square = new Square(rowIdx, rowIdx, colIdx, colIdx);
                    singleSquares.add(square);
                }
            }
        }

        // now singleSquares contains all the squares of area 1

        int biggest = 0;
        for (Square square : singleSquares) {
            biggest = Math.max(biggest, findBiggest(square));
        }

        return biggest;
    }

    private int findBiggest(Square square) {
        if (cache.containsKey(square)) {
            return cache.get(square);
        }
        boolean squaresToRightAreOnes = squaresToRightAreOnes(square);
        boolean squaresToLeftAreOnes = squaresToLeftAreOnes(square);
        boolean squaresDownAreOnes = squaresDownAreOnes(square);
        boolean squaresUpAreOnes = squaresUpAreOnes(square);

        int area = (square.rightCol - square.leftCol + 1) * (square.bottomRow - square.topRow + 1);
        if (squaresToRightAreOnes && squaresDownAreOnes) {
            if (matrix[square.bottomRow + 1][square.rightCol + 1] == '1') {
                Square newSquare = new Square(square.topRow, square.bottomRow + 1, square.leftCol, square.rightCol + 1);
                area = Math.max(area, findBiggest(newSquare));
            }
        }
        if (squaresToLeftAreOnes && squaresDownAreOnes) {
            if (matrix[square.bottomRow + 1][square.leftCol - 1] == '1') {
                Square newSquare = new Square(square.topRow, square.bottomRow + 1, square.leftCol - 1, square.rightCol);
                area = Math.max(area, findBiggest(newSquare));
            }
        }
        if (squaresToLeftAreOnes && squaresUpAreOnes) {
            if (matrix[square.topRow - 1][square.leftCol - 1] == '1') {
                Square newSquare = new Square(square.topRow - 1, square.bottomRow, square.leftCol - 1, square.rightCol);
                area = Math.max(area, findBiggest(newSquare));
            }
        }
        if (squaresToRightAreOnes && squaresUpAreOnes) {
            if (matrix[square.topRow - 1][square.rightCol + 1] == '1') {
                Square newSquare = new Square(square.topRow - 1, square.bottomRow, square.leftCol, square.rightCol + 1);
                area = Math.max(area, findBiggest(newSquare));
            }
        }
        cache.put(square, area);
        return area;
    }

    private boolean squaresUpAreOnes(Square square) {
        if (square.topRow <= 0) {
            return false;
        }
        for (int colIdx = square.leftCol; colIdx <= square.rightCol; colIdx++) {
            if (matrix[square.topRow - 1][colIdx] != '1') {
                return false;
            }
        }
        return true;
    }

    private boolean squaresDownAreOnes(Square square) {
        if (square.bottomRow >= numRows - 1) {
            return false;
        }
        for (int colIdx = square.leftCol; colIdx <= square.rightCol; colIdx++) {
            if (matrix[square.bottomRow + 1][colIdx] != '1') {
                return false;
            }
        }
        return true;
    }

    private boolean squaresToLeftAreOnes(Square square) {
        if (square.leftCol <= 0) {
            return false;
        }
        for (int rowIdx = square.topRow; rowIdx <= square.bottomRow; rowIdx++) {
            if (matrix[rowIdx][square.leftCol - 1] != '1') {
                return false;
            }
        }
        return true;
    }

    private boolean squaresToRightAreOnes(Square square) {
        if (square.rightCol >= numCols - 1) {
            return false;
        }
        for (int rowIdx = square.topRow; rowIdx <= square.bottomRow; rowIdx++) {
            if (matrix[rowIdx][square.rightCol + 1] != '1') {
                return false;
            }
        }
        return true;
    }
}
