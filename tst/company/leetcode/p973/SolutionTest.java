package company.leetcode.p973;

import com.company.leetcode.p973.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void example() {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }

    @Test
    public void exampleTwo() {
        Solution solution = new Solution();
        int[][] array = new int[][]{{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(solution.kClosest(array, 2)));
    }
}