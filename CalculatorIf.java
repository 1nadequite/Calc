package calculator;

public interface CalculatorIf {
    void executeUnaryOperation(UnaryOperationType opType);
    void executeBinaryOperation(BinaryOperationType opType, double right);
    double getValue();
}
