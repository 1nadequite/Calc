package calculator;

/**
 * Engineering calculator with memory has the same operations
 * as the algorithm calculator with memory and the engineering calculator.
 */
public class EngineeringCalculatorWithMemory extends EngineeringCalculator {
    EngineeringCalculatorWithMemory(Memory memory) {
        super();

        unaryOperations.put(UnaryOperationType.MC, new MCOperation(memory));
        unaryOperations.put(UnaryOperationType.MS, new MSOperation(memory));
        unaryOperations.put(UnaryOperationType.MADD, new MAddOperation(memory));
        unaryOperations.put(UnaryOperationType.MSUB, new MSubOperation(memory));
    }
}
