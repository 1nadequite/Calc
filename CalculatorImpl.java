package calculator;

import calculator.BinaryOperations.BinaryOperationIf;
import calculator.ExpressionType.BinaryExpression;
import calculator.ExpressionType.UnaryExpression;
import calculator.UnaryOperaions.UnaryOperationIf;

import java.util.HashMap;

/**
 * Class that stores and implements all the unary and binary operations
 * and returns the current value.
 */
public class CalculatorImpl implements CalculatorIf {
    // execute unary operation if it exists
    @Override
    public double executeUnaryOperation(UnaryExpression expType) {
        UnaryOperationType op = OperationParser.maybeUnaryOperation(expType.getOperation());
        if (unaryOperations.get(op) != null) {
            return unaryOperations.get(op).execute(expType.getValue());
        } else {
            throw new IllegalArgumentException("Unavailable unary operation.");
        }
    }

    // execute binary operation if it exists
    @Override
    public double executeBinaryOperation(BinaryExpression expType) {
        BinaryOperationType op = OperationParser.maybeBinaryOperation(expType.getOperation());
        if (binaryOperations.get(op) != null) {
            return binaryOperations.get(op).execute(expType.getLeft(), expType.getRight());
        } else {
            throw new IllegalArgumentException("Unavailable binary operation.");
        }
    }

    protected HashMap<UnaryOperationType, UnaryOperationIf> unaryOperations =
            new HashMap<UnaryOperationType, UnaryOperationIf>();
    protected HashMap<BinaryOperationType, BinaryOperationIf> binaryOperations =
            new HashMap<BinaryOperationType, BinaryOperationIf>();
}
