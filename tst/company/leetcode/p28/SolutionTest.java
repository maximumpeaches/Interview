package company.leetcode.p28;

import com.company.leetcode.p28.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void myMadeUp() {
        String haystack = "aefoaefcdaefcdaed";
        String needle = "aefcdaed";
        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);
        assertEquals(9, result);
    }
}