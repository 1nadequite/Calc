package calculator;

import java.util.HashMap;

/**
 * An parser that stores and returns all operations.
 */
public class OperationParser {
    private static HashMap<String, UnaryOperationType> unaryOperations =
            new HashMap<String, UnaryOperationType>();
    private static HashMap<String, BinaryOperationType> binaryOperations =
            new HashMap<String, BinaryOperationType>();

    // the all operations.
    static {
        unaryOperations.put("MC", UnaryOperationType.MC);
        unaryOperations.put("MS", UnaryOperationType.MS);
        unaryOperations.put("M+", UnaryOperationType.MADD);
        unaryOperations.put("M-", UnaryOperationType.MSUB);
        unaryOperations.put("cos", UnaryOperationType.COS);
        unaryOperations.put("exp", UnaryOperationType.EXP);
        unaryOperations.put("square", UnaryOperationType.SQUARE);

        binaryOperations.put("+", BinaryOperationType.ADDITION);
        binaryOperations.put("-", BinaryOperationType.SUBTRACT);
        binaryOperations.put("*", BinaryOperationType.MULTIPLY);
        binaryOperations.put("/", BinaryOperationType.DIVIDE);
    }

    // verify if a unary operation exists
    public static UnaryOperationType maybeUnaryOperation(String operation) {
        if (unaryOperations.get(operation) != null) {
            return unaryOperations.get(operation);
        } else {
            return null;
        }
    }

    // verify if a binary operation exists
    public static BinaryOperationType maybeBinaryOperation(String operation) {
        if (binaryOperations.get(operation) != null) {
            return binaryOperations.get(operation);
        } else {
            return null;
        }
    }

}
