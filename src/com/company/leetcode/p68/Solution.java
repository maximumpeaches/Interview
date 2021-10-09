package com.company.leetcode.p68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final class Line {
        private int maxLength;
        private int currentLength = 0;
        private List<String> words = new ArrayList<>();
        private boolean lastWord = false;

        private Line(int maxLength) {
            this.maxLength = maxLength;
        }

        private boolean tryAdd(String word) {
            if (currentLength == 0) {
                currentLength += word.length();
                words.add(word);
                return true;
            }
            boolean canAddWord = currentLength + word.length() + 1 <= maxLength;
            if (canAddWord) {
                currentLength += word.length() + 1;
                words.add(word);
                return true;
            } else {
                return false;
            }
        }

        private void flagAsLastWord() {
            lastWord = true;
        }

        @Override
        public String toString() {
            if (lastWord) {
                return toStringLastWord();
            } else {
                return toStringNotLastWord();
            }
        }

        private String toStringNotLastWord() {

            int charCount = 0;
            for (String word : words) {
                charCount += word.length();
            }
            int emptySpaces = this.maxLength - charCount;
            int numEmptySpots = this.words.size() == 1 ? 1 : this.words.size() - 1;
            int spareSpaces = emptySpaces % numEmptySpots;
            int minSpacesPerSpot = emptySpaces / numEmptySpots;

            StringBuilder sb = new StringBuilder(this.maxLength);
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                sb.append(word);
                if (emptySpaces > 0) {
                    int spacesAfterWord;
                    if (spareSpaces > 0) {
                        spacesAfterWord = minSpacesPerSpot + 1;
                        spareSpaces--;
                    } else {
                        spacesAfterWord = minSpacesPerSpot;
                    }
                    emptySpaces -= spacesAfterWord;
                    for (int j = 0; j < spacesAfterWord; j++) {
                        sb.append(' ');
                    }
                }

            }
            return sb.toString();
        }

        private String toStringLastWord() {
            int charCount = 0;
            for (String word : words) {
                charCount += word.length();
            }
            int emptySpaces = this.maxLength - charCount;

            StringBuilder sb = new StringBuilder(this.maxLength);
            for (String word : words) {
                sb.append(word);
                if (emptySpaces > 0) {
                    sb.append(' ');
                    emptySpaces--;
                }
            }
            for (int i = 0; i < emptySpaces; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(maxWidth));

        for (String word : words) {
            Line last = lines.get(lines.size() - 1);
            if (!last.tryAdd(word)) {
                Line newLine = new Line(maxWidth);
                lines.add(newLine);
                newLine.tryAdd(word);
            }
        }

        Line last = lines.get(lines.size() - 1);
        last.flagAsLastWord();

        List<String> result = new ArrayList<>(lines.size());
        for (Line line : lines) {
            result.add(line.toString());
        }
        return result;
    }
}
