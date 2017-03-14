package calculator.ExpressionType;

/**
 * Structure for unary expression.
 */
public class UnaryExpression implements Expression {
    public UnaryExpression(String op, double value) {
        this.op = op;
        this.value = value;
    }

    // get unary operation
    @Override
    public String getOperation() {
        return op;
    }
    // get operand
    public double getValue() {
        return value;
    }

    private String op;
    private double value;
}
