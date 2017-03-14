package calculator.UnaryOperaions;

/**
 * Sin operation calculates the sin of a value;
 */
public class SinOperation implements UnaryOperationIf {
    @Override
    public double execute(double value) {
        return Math.sin(Math.toRadians(value));
    }
}
