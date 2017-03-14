package calculator.UnaryOperaions;

/**
 * Cos operation calculates the cos of a value;
 */
public class CosOperation implements UnaryOperationIf {
    @Override
    public double execute(double value) {
        return Math.cos(Math.toRadians(value));
    }
}
