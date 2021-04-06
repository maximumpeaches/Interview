package company.leetcode.p1675;

import com.company.leetcode.p1675.Solution;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Solution solution;

    @BeforeEach
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void exampleOne() {
        int[] nums = new int[]{1, 2, 3, 4};
        assertEquals(1, solution.minimumDeviation(nums));
    }

    @Test
    public void exampleTwo() {
        int[] nums = new int[]{4, 1, 5, 20, 3};
        assertEquals(3, solution.minimumDeviation(nums));
    }

    @Test
    public void exampleThree() {
        int[] nums = new int[]{2, 10, 8};
        assertEquals(3, solution.minimumDeviation(nums));
    }

    @Test
    public void testFour() {
        int[] nums = new int[]{3, 5};
        assertEquals(3, solution.minimumDeviation(nums));
    }
}