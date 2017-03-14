package calculator.BinaryOperations;

/**
 * Power operation raises the left value to the power of the right value.
 */
public class PowerOperation implements BinaryOperationIf {
    @Override
    public double execute(double left, double right) {
        return Math.pow(left, right);
    }
}
