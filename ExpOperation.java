package calculator;

/**
 * Exp operation calculates the exp of a value;
 */
public class ExpOperation implements UnaryOperationIf {
    public double execute(double value) {
        return Math.exp(value);
    }
}
