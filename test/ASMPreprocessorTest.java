import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ASMPreprocessorTest {
    @Test
    public void testProcess() {
        List<String> program = new ArrayList<>();
        // line 0
        program.add("@sum");
        // line 1
        program.add("M=0");
        program.add("(LOOP)");
        program.add("");
        program.add("// Computes R1=1 + ... + R0");
        program.add("// i = 1");
        // line 2
        program.add("@i // create index");
        // line 3
        program.add("D=M");
        // line 4
        program.add("@R0");
        // line 5
        program.add("D = D - M");
        // line 6
        program.add("@END");
        // line 7
        program.add("D;JGT");
        // line 8
        program.add("@LOOP");
        // line 9
        program.add("D=D+M;JMP");
        // line 10
        program.add("@1234");
        // line 11
        program.add("M=D");
        program.add("(END)");
        // line 12
        program.add("@END");
        // line 13
        program.add("0;JMP");

        ASMPreprocessor preprocessor = new ASMPreprocessor();
        List<String> result = preprocessor.process(program);

        List<String> expected = new ArrayList<>();
        // line 0
        expected.add("@16");
        // line 1
        expected.add("M=0");
        // line 2
        expected.add("@17");
        // line 3
        expected.add("D=M");
        // line 4
        expected.add("@0");
        // line 5
        expected.add("D=D-M");
        // line 6
        expected.add("@12");
        // line 7
        expected.add("D;JGT");
        // line 8
        expected.add("@2");
        // line 9
        expected.add("D=D+M;JMP");
        // line 10
        expected.add("@1234");
        // line 11
        expected.add("M=D");
        // line 12
        expected.add("@12");
        // line 13
        expected.add("0;JMP");
        assertEquals(expected, result);
    }
}
