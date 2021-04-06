package company.algoexpert.knuthmorrisprattalgorithm;

import com.company.algoexpert.knuthmorrisprattalgorithm.Program;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ProgramTest {
    @Test
    public void sampleInput() {
        String string = "aefoaefcdaefcdaed";
        String substring = "aefcdaed";
        boolean result = Program.knuthMorrisPrattAlgorithm(string, substring);
        assertTrue(result);
    }
}