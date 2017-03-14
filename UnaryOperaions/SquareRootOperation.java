package calculator.UnaryOperaions;

/**
 * Square root operation calculates the square root of a value;
 */
public class SquareRootOperation implements UnaryOperationIf {
    @Override
    public double execute(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Square root of a negative number is not a number.");
        }
        return Math.sqrt(value);
    }
}
