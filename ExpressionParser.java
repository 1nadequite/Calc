package calculator;

import calculator.ExpressionType.BinaryExpression;
import calculator.ExpressionType.Expression;
import calculator.ExpressionType.UnaryExpression;

import java.util.Stack;

/**
 * Create and return expressions.
 */
public class ExpressionParser {

    // store the value and return next possible unary expression
    public UnaryExpression addValue(String line) {
        if (!operation.isEmpty() && braces && OperationParser.maybeUnaryOperation(operation.peek()) != null) {
            return new UnaryExpression(operation.pop(), Double.parseDouble(line));
        } else {
            numbers.push(Double.parseDouble(line));
            return null;
        }
    }

    public UnaryExpression addValue(double value) {

        if (!operation.isEmpty() && !braces && OperationParser.maybeUnaryOperation(operation.peek()) != null) {
            System.out.println(operation.peek());
            return new UnaryExpression(operation.pop(), value);
        } else {
            numbers.push(value);
            return null;
        }
    }

    // store unary operation and braces
    public void addUnaryOperation(String line) {
        operation.push(line);
    }

    // store binary operation and return next possible unary or binary expression
    public Expression getNextExpression(String opType) {
        if (opType != null && !opType.equals(")") && operation.isEmpty()) {
            operation.push(opType);
            return null;
        } else if (opType != null && opType.equals(")")) {
            braces = true;
        }
        if (opType == null || opType.equals(")")) {
            if (!operation.isEmpty() && operation.peek().equals("(") && braces) {
                braces = false;
                operation.pop();
                if (!operation.isEmpty() && OperationParser.maybeUnaryOperation(operation.peek()) != null) {
                    return new UnaryExpression(operation.pop(), numbers.pop());
                } else {
                    return null;
                }
            }
            if (!operation.isEmpty()) {
                if (OperationParser.maybeUnaryOperation(operation.peek()) != null) {
                    return new UnaryExpression(operation.pop(), numbers.pop());
                } else if (OperationParser.maybeBinaryOperation(operation.peek()) != null) {
                    return new BinaryExpression(numbers.pop(), operation.pop(), numbers.pop());
                }
            }
        } else {
            if (!operation.isEmpty()) {
                String prevOpType = operation.peek();
                if (prevOpType.equals("(")) {
                    operation.push(opType);
                    return null;
                }
                int prevPriority = BinaryOperationType.getPriority(OperationParser.maybeBinaryOperation(prevOpType));
                int curPriority = BinaryOperationType.getPriority(OperationParser.maybeBinaryOperation(opType));
                if (opType.equals(")") || (
                        (prevPriority == 3 && prevPriority > curPriority) || (prevPriority != 3 && prevPriority >= curPriority)
                )) {
                    return new BinaryExpression(numbers.pop(), operation.pop(), numbers.pop());
                }
            }
            operation.push(opType);
        }
        return null;
    }

    // return the answer
    public double getAnswer() { return numbers.pop(); }

    boolean braces = false;
    boolean prevOp = false;
    private Stack<Double> numbers = new Stack<Double>();
    private Stack<String> operation = new Stack<String>();
}
