package company.algoexpert.smallestsubstringcontaining;

import com.company.algoexpert.smallestsubstringcontaining.Program;
import org.junit.jupiter.api.Test;

class ProgramTest {
    @Test
    public void inputOne() {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$abf";
        String result = Program.smallestSubstringContaining(bigString, smallString);
        System.out.println(result);
    }
}