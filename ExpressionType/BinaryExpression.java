package calculator.ExpressionType;

/**
 * Structure for binary expression.
 */
public class BinaryExpression implements Expression {
    public BinaryExpression(double right, String op, double left) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    // get left operand
    public double getLeft() {
        return left;
    }
    // get binary operation
    @Override
    public String getOperation() { return op; }
    // get right operand
    public double getRight() {
        return right;
    }

    private double left;
    private String op;
    private double right;
}
