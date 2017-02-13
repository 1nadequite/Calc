package calculator;

import java.util.HashMap;

/**
 * Class that stores and implements all the unary and binary operations
 * and returns the current value.
 */
public class CalculatorImpl implements CalculatorIf {
    // execute unary operation if it exists
    public void executeUnaryOperation(UnaryOperationType opType) {
        if (unaryOperations.get(opType) != null) {
            value = unaryOperations.get(opType).execute(value);
        } else {
            throw new IllegalArgumentException("Unavailable unary operation.");
        }
    }

    // execute binary operation if it exists
    public void executeBinaryOperation(BinaryOperationType opType, double right) {
        if (binaryOperations.get(opType) != null) {
            value = binaryOperations.get(opType).execute(value, right);
        } else {
            throw new IllegalArgumentException("Unavailable binary operation.");
        }
    }

    // return the current value
    public double getValue() {
        return value;
    }

    protected HashMap<UnaryOperationType, UnaryOperationIf> unaryOperations =
            new HashMap<UnaryOperationType, UnaryOperationIf>();
    protected HashMap<BinaryOperationType, BinaryOperationIf> binaryOperations =
            new HashMap<BinaryOperationType, BinaryOperationIf>();

    private double value = 0.0;
}
