package calculator;

import calculator.BinaryOperations.*;

/**
 * Arithmetic calculator has following binary operations:
 * - addition("+");
 * - subtract("-");
 * - multiply("*");
 * - divide("/");
 * - power("^").
 */
public class ArithmeticCalculator extends CalculatorImpl {
    ArithmeticCalculator() {
        binaryOperations.put(BinaryOperationType.ADDITION, new AdditionOperation());
        binaryOperations.put(BinaryOperationType.SUBTRACT, new SubtractOperation());
        binaryOperations.put(BinaryOperationType.MULTIPLY, new MultiplyOperation());
        binaryOperations.put(BinaryOperationType.DIVIDE, new DivideOperation());
        binaryOperations.put(BinaryOperationType.POWER, new PowerOperation());
    }
}
