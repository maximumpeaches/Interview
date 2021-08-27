package com.company.leetcode.p394;

public class Solution {
    private String s;
    public String decodeString(String s) {
        this.s = s;
        return decode(0).toString();
    }

    private StringBuilder decode(int pos) {
        StringBuilder sb = new StringBuilder(1);
        while (pos < this.s.length()) {
            char c = this.s.charAt(pos);
            if (c == ']') {
                break;
            } else if (Character.isLowerCase(c)) {
                sb.append(c);
                pos++;
                c = this.s.charAt(pos);
            } else if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder(3);
                while (Character.isDigit(c)) {
                    number.append(c);
                    pos++;
                    c = this.s.charAt(pos);
                }
                int n = Integer.parseInt(number.toString());
                // we know that pos must be at an opening bracket because input is well formed and we just saw a number
                StringBuilder r = decode(pos + 1);
                sb.append(r.toString().repeat(n));
                pos = pos + r.length() + 2;
            } // no other else case since input is well formed
        }

        return sb;
    }
}
