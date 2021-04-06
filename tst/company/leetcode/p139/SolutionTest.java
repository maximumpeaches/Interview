package company.leetcode.p139;

import com.company.leetcode.p139.Solution;
import com.company.leetcode.p139.Solution1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void solutionOne() {
        Solution1 solution = new Solution1();
        exampleOne(solution);
    }

    private void exampleOne(Solution solution) {
        boolean result = solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
        assertTrue(result);
    }

    private void exampleTwo(Solution solution) {
        boolean result = solution.wordBreak("applepenapple", Arrays.asList("apple","pen"));
        assertTrue(result);
    }

    private void exampleThree(Solution solution) {
        boolean result = solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"));
        assertFalse(result);
    }
}