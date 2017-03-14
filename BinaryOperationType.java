package calculator;

import java.util.HashMap;

/**
 * Enum with the binary operations.
 */
public enum BinaryOperationType {
    ADDITION(1),
    SUBTRACT(1),
    MULTIPLY(2),
    DIVIDE(2),
    POWER(3);

    BinaryOperationType(int priority) { this.priority = priority; }

    private static final HashMap<BinaryOperationType, Integer> operationPriority =
            new HashMap<BinaryOperationType, Integer>();

    // filling the map by the all binary operation priority
    static {
        for (BinaryOperationType type : BinaryOperationType.values()) {
            operationPriority.put(type, type.priority);
        }
    }

    // return the priority number by the operation type
    public static Integer getPriority(BinaryOperationType op) { return operationPriority.get(op); }

    private final int priority;
}

