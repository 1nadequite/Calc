package calculator;

import calculator.ExpressionType.BinaryExpression;
import calculator.ExpressionType.UnaryExpression;

public interface CalculatorIf {
    double executeUnaryOperation(UnaryExpression expType) throws IllegalArgumentException;
    double executeBinaryOperation(BinaryExpression expType) throws IllegalArgumentException;
}
