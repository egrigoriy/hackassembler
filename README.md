# Assembler for Hack Machine Language from nand2tetris written in java

This is a Java implementation of a 16-bit machine language assembler for the Hack Assembly language. 
It is written as part of the NandToTetris course: https://www.nand2tetris.org/project06.
The Hack Language specifications can be found here: https://www.nand2tetris.org/project04.

# Description

1. **HackAssembler.java**: drives the process of translating code written in the Hack assembly language into machine code, 
according to the Hack Language specifications (see lecture4.pdf). It is responsible for reading the input file (*.asm) and writing the output one (*.hack).
2. **ASMProgram.java**: manages preprocessing and parsing of the file and provides translation to binary format of all instructions.
3. **Instruction.java**, **AInstruction.java**, **CInstruction.java**: Provide the interface and implementations of A-instructions and C-instructions as specified by the Hack Language specification..
4. **ASMPreprocessor.java**: applies all its handlers the input program.
5. **ASMPreprocessorHandler.java**: defines the interface for all ASMProcessHandlers.
6. **RemoveEmptyLinesHandler.java**: a ASMProcessHandler that removes all empty lines from given input program.
7. **RemoveEmptySpacesHandler.java**: a ASMProcessHandler that removes all spaces from given input program.
9. **RemoveCommentsHandler.java**: a ASMProcessHandler that removes all full and end-of-line comments from given input program.
10. **LabelsHandler.java**: a ASMProcessHandler that handles labels by removing by removing label pseudo-instructions and replacing label referencing with corresponding address.
11. **VariablesHandler.java**: a ASMProcessHandler that handles variables by replacing them with corresponding address
11. **ASMParser.java**: parses all input instructions to a list of AInstruction or CInstruction objects.
12. **SymbolTable.java**: manages a table of symbols including predefined variables **PredefinedSymbols.java**, user-defined variables and labels.

# Usage

```bash
$ javac HackAssembler.java
$ java HackAssembler YourASMProgram.asm
```
 
# License

This project is licensed under the [GNU General Public License v3.0](LICENSE)

