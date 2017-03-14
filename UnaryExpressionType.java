package calculator;

public class BinaryExpressionType implements ExpressionType {
    BinaryExpressionType(double left, BinaryOperationType op, double right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    // get left operand
    public double getLeft() {
        return left;
    }
    // get binary operation
    public BinaryOperationType getOperation() {
        return op;
    }
    // get right operand
    public double getRight() {
        return right;
    }


    private double left;
    private BinaryOperationType op;
    private double right;
}
