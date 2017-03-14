package calculator;

/**
 * Cos operation calculates the cos of a value;
 */
public class CosOperation implements UnaryOperationIf {
    @Override
    public double execute(double value) {
        return Math.cos(value);
    }
}
