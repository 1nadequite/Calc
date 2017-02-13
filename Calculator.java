package calculator;

import java.util.Scanner;

/**
 * Calculator
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int calculatorType;
        while (true) {
            calculatorType = reader.nextInt();
            if (CalculatorType.isValidType(calculatorType)) break;
            System.out.println("Incorrect calculator type. Type has to be between 1 and 4");
        }

        CalculatorImpl calc = null;
        Memory memory = null;
        switch (CalculatorType.forValue(calculatorType)) {
            case ARITHMETIC:
                calc = new ArithmeticCalculator();
                break;
            case ARITHMETIC_WITH_MEMORY:
                memory = new Memory();
                calc = new ArithmeticCalculatorWithMemory(memory);
                break;
            case ENGINEERING:
                calc = new EngineeringCalculator();
                break;
            case ENGINEERING_WITH_MEMORY:
                memory = new Memory();
                calc = new EngineeringCalculatorWithMemory(memory);
                break;
        }
        System.out.println(CalculatorType.calculatorName(calculatorType));

        BinaryOperationType previousBinaryOperation = BinaryOperationType.ADDITION;
        while (true) {
            try {
                String line = reader.next();
                if (OperationParser.maybeUnaryOperation(line) != null) {
                    calc.executeUnaryOperation(OperationParser.maybeUnaryOperation(line));
                } else if (OperationParser.maybeBinaryOperation(line) != null) {
                    previousBinaryOperation = OperationParser.maybeBinaryOperation(line);
                } else if (line.equals("=")) {
                    System.out.println(calc.getValue());
                } else if (line.equals("exit")) {
                    break;
                } else if (line.equals("MR")) {
                    if (memory == null) {
                        throw new IllegalArgumentException("Unavailable operation");
                    }
                    double operand = memory.recall();
                    calc.executeBinaryOperation(previousBinaryOperation, operand);
                } else {
                    double operand = Double.parseDouble(line);
                    calc.executeBinaryOperation(previousBinaryOperation, operand);
                }
            } catch (NumberFormatException ex) {
                System.out.format("Format exception(%s)\n", ex.getMessage());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
