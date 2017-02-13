package calculator.BinaryOperations;

/**
 * Divide operation divides the left value by the right value.
 */
public class DivideOperation implements BinaryOperationIf {
    public double execute(double left, double right) {
        if (right == 0) {
            throw new IllegalArgumentException("Divide by zero.");
        }
        return left / right;
    }
}
