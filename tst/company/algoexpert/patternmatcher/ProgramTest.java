package company.algoexpert.patternmatcher;

import com.company.algoexpert.patternmatcher.Program;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProgramTest {
    @Test
    public void testCaseOne() {
        String pattern = "xxyxxy";
        String s = "gogopowerrangergogopowerranger";
        String[] result = Program.patternMatcher(pattern, s);
        System.out.println(Arrays.toString(result));
    }
    @Test
    public void testCaseSeven() {
        String pattern = "xxxx";
        String s = "testtesttesttest";
        String[] result = Program.patternMatcher(pattern, s);
        System.out.println(Arrays.toString(result));
    }
}