package calculator;

import java.util.HashMap;

/**
 * Calculator types and names.
 * Returns calculator types and values by the value.
 * And also check if the calculator type exists.
 */
public enum CalculatorType {
    ARITHMETIC(1),
    ARITHMETIC_WITH_MEMORY(2),
    ENGINEERING(3),
    ENGINEERING_WITH_MEMORY(4);

    CalculatorType(int value) { this.value = value; }

    private static final HashMap<Integer, CalculatorType> typesByValue = new HashMap<Integer, CalculatorType>();
    private static final HashMap<Integer, String> namesByValue = new HashMap<Integer, String>();

    // filling the map by the all calculator types
    static {
        for (CalculatorType type : CalculatorType.values()) {
            typesByValue.put(type.value, type);
        }
        namesByValue.put(1, "Arithmetic Calculator");
        namesByValue.put(2, "Arithmetic Calculator with Memory");
        namesByValue.put(3, "Engineering Calculator");
        namesByValue.put(4, "Engineering Calculator with Memory");
    }

    // return the calculator type by the value
    public static CalculatorType forValue(int value) {
        return typesByValue.get(value);
    }

    // return the calculator name by the value
    public static String calculatorName(int value) { return namesByValue.get(value); }

    // check if calculator type exists
    public static boolean isValidType(int value) { return typesByValue.get(value) != null; }

    private final int value;
}
