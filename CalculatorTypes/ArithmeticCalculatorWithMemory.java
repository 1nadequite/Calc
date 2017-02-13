package calculator;

import calculator.CalculatorTypes.ArithmeticCalculator;
import calculator.Types.UnaryOperationType;
import calculator.UnaryOperations.MAddOperation;
import calculator.UnaryOperations.MCOperation;
import calculator.UnaryOperations.MSOperation;
import calculator.UnaryOperations.MSubOperation;

/**
 * Arithmetic calculator with Memory has the all arithmetic operations
 * and following memory operations:
 * "MC" - clear the memory;
 * "MS" - store the value into the memory;
 * "M+" - add the value to the memory;
 * "M-" - subtract the value from the memory.
 */
public class ArithmeticCalculatorWithMemory extends ArithmeticCalculator {
    ArithmeticCalculatorWithMemory(Memory memory) {
        super();

        unaryOperations.put(UnaryOperationType.MC, new MCOperation(memory));
        unaryOperations.put(UnaryOperationType.MS, new MSOperation(memory));
        unaryOperations.put(UnaryOperationType.MADD, new MAddOperation(memory));
        unaryOperations.put(UnaryOperationType.MSUB, new MSubOperation(memory));
    }
}
