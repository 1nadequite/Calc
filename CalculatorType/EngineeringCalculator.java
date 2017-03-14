package calculator;

import calculator.UnaryOperaions.CosOperation;
import calculator.UnaryOperaions.SinOperation;
import calculator.UnaryOperaions.SquareRootOperation;

/**
 * Engineering calculator has the all arithmetic operations
 * and following unary operations:
 * - "sin";
 * - "cos";
 * - "sqrt".
 */
public class EngineeringCalculator extends ArithmeticCalculator {
    EngineeringCalculator() {
        super();

        unaryOperations.put(UnaryOperationType.SIN, new SinOperation());
        unaryOperations.put(UnaryOperationType.COS, new CosOperation());
        unaryOperations.put(UnaryOperationType.SQRT, new SquareRootOperation());
    }
}
