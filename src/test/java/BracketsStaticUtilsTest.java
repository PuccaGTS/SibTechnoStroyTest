import brackets.BracketsStaticUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BracketsStaticUtilsTest {
    @ParameterizedTest
    @MethodSource("testDataEncoding")
    public void bracketEncodingTest(String input, String expectedOutput) {
        assertEquals(expectedOutput, BracketsStaticUtils.bracketEncoding(input));
    }

    private static Stream<String[]> testDataEncoding() {
        return Stream.of(
                new String[]{"((aabbcc))", "))))))))))"},
                new String[]{"abc", "((("},
                new String[]{"AaBbCc", "))))))"},
                new String[]{"din", "((("},
                new String[]{"Success", ")())())"},
                new String[]{"pip", ")()"},
                new String[]{"((@", "))("}
        );
    }

    @ParameterizedTest
    @MethodSource("testDataValidator")
    public void bracketSequenceValidatorTest(String input, String expectedOutput) {
        boolean expected = Boolean.parseBoolean(expectedOutput);
        assertEquals(expected, BracketsStaticUtils.bracketSequenceValidator(input));
    }

    private static Stream<String[]> testDataValidator() {
        return Stream.of(
                new String[]{"(())", "true"},
                new String[]{"{[()]}", "true"},
                new String[]{"(()))", "false"},
                new String[]{"{{{{", "false"},
                new String[]{"[(])", "false"}
        );
    }
}
