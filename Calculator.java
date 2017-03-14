package calculator;

import calculator.CalculatorType.ArithmeticCalculator;
import calculator.CalculatorType.CalculatorType;
import calculator.CalculatorType.EngineeringCalculator;
import calculator.CalculatorType.ImprovedArithmeticCalculator;
import calculator.ExpressionType.BinaryExpression;
import calculator.ExpressionType.Expression;
import calculator.ExpressionType.UnaryExpression;

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
            if (CalculatorType.isValidType(calculatorType)) {
                break;
            }
            System.out.println("Incorrect calculator type(1 - arithmetic, 2 - improved arithmetic, 3 - engineering).");
        }

        CalculatorImpl calc = null;
        switch (CalculatorType.forValue(calculatorType)) {
            case ARITHMETIC:
                calc = new ArithmeticCalculator();
                break;
            case IMPROVED_ARITHMETIC:
                calc = new ImprovedArithmeticCalculator();
                break;
            case ENGINEERING:
                calc = new EngineeringCalculator();
                break;
        }
        System.out.println(CalculatorType.calculatorName(calculatorType));
        reader.nextLine();

        String start_line = reader.nextLine();
        Parser parsed_line = new Parser(start_line);
        ExpressionParser exp = new ExpressionParser();
        while (true) {
            try {
                String line = parsed_line.getNextValue();
                double new_value;
                Expression cur_exp;
                UnaryExpression unary_exp;
                if (line == null || line.equals(")") || OperationParser.maybeBinaryOperation(line) != null) {

                    cur_exp = exp.getNextExpression(line);

                    while (cur_exp != null) {
                        if (OperationParser.maybeBinaryOperation(cur_exp.getOperation()) != null) {
                            new_value = calc.executeBinaryOperation((BinaryExpression) cur_exp);
                        } else {
                            new_value = calc.executeUnaryOperation((UnaryExpression) cur_exp);
                        }
                        unary_exp = exp.addValue(new_value);
                        if (unary_exp != null) {
                            exp.addValue(calc.executeUnaryOperation(unary_exp));
                        }
                        cur_exp = (line == null || line.equals(")"))
                                ? exp.getNextExpression(null)
                                : exp.getNextExpression(line);
                    }

                    if (line == null) {
                        System.out.format("%s = %.5f", start_line, exp.getAnswer());
                        break;
                    }

                } else if (OperationParser.maybeUnaryOperation(line) != null || line.equals("(")) {
                    exp.addUnaryOperation(line);
                } else {
                    unary_exp = exp.addValue(line);
                    if (unary_exp != null) {
                        exp.addValue(calc.executeUnaryOperation(unary_exp));
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
    }
}
