package calculator.CalculatorType;

import calculator.BinaryOperationType;
import calculator.BinaryOperations.*;
import calculator.CalculatorImpl;

/**
 * Arithmetic calculator has following binary operations:
 * - addition("+");
 * - subtract("-");
 * - multiply("*");
 * - divide("/");
 * - power("^").
 */
public class ArithmeticCalculator extends CalculatorImpl {
    public ArithmeticCalculator() {
        // add the all binary operations
        binaryOperations.put(BinaryOperationType.ADDITION, new AdditionOperation());
        binaryOperations.put(BinaryOperationType.SUBTRACT, new SubtractOperation());
        binaryOperations.put(BinaryOperationType.MULTIPLY, new MultiplyOperation());
        binaryOperations.put(BinaryOperationType.DIVIDE, new DivideOperation());
        binaryOperations.put(BinaryOperationType.POWER, new PowerOperation());
    }
}
