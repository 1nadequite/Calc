package calculator;

/**
 * Square operation calculates the square of a value;
 */
public class SquareOperation implements UnaryOperationIf {
    public double execute(double value) {
        return value * value;
    }
}
