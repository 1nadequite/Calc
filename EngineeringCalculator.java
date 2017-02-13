package calculator;

/**
 * Engineering calculator has the all arithmetic operations
 * and following unary operations:
 * - "cos";
 * - "exp";
 * - "square".
 */
public class EngineeringCalculator extends ArithmeticCalculator {
    EngineeringCalculator() {
        super();

        unaryOperations.put(UnaryOperationType.COS, new CosOperation());
        unaryOperations.put(UnaryOperationType.EXP, new ExpOperation());
        unaryOperations.put(UnaryOperationType.SQUARE, new SquareOperation());
    }
}
