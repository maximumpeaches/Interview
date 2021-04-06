# Advice to future me
Notice example #2 which says the solution should return "AB" when str1 = "ABABAB", str2 = "ABAB".
I feel like this problem is phrased in a tricky way because it doesn't call that out very clearly.

This is a decent problem to review for string matching, but would also be good to review other problems which 
involve string matching, and learn about string matching in general.

## Feb 24th 2021
Spent 1 hour on this. Didn't solve it because question is phrased in a tricky way, so I solved a different question.

## Current description
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Constraints:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1 and str2 consist of English uppercase letters.

