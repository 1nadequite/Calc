package calculator;

/**
 * Parser converts the expression into numbers and operators.
 */
public class Parser {
    Parser(String exp) {
        this.expression_ = exp;
        this.size_ = exp.length();
        this.position_ = 0;
    }

    public String getNextValue() {
        String nextValue = new String();
        for (; position_ < size_; position_++) {
            Character cur_char = expression_.charAt(position_);
            if (Character.isDigit(cur_char)) {
                while (position_ < size_ &&
                        (Character.isDigit(expression_.charAt(position_)) || expression_.charAt(position_) == '.')) {
                    nextValue += expression_.charAt(position_);
                    position_++;
                }
                return nextValue;
            } else if (cur_char == '+' || cur_char == '-' || cur_char == '/' || cur_char == '*' ||
                       cur_char == '^' || cur_char == '√' || cur_char == '(' || cur_char == ')') {
                nextValue += cur_char;
                position_++;
                break;
            } else if (cur_char == 's' || cur_char == 'c') {
                for (int i = 0; i < 3; ++i) {
                    nextValue += expression_.charAt(position_);
                    position_++;
                }
                break;
            } else {
                continue;
            }
        }
        if (nextValue.isEmpty()) {
            return null;
        } else if (OperationParser.maybeUnaryOperation(nextValue) != null ||
                   OperationParser.maybeBinaryOperation(nextValue) != null ||
                   nextValue.equals("(") || nextValue.equals(")")) {
            return nextValue;
        } else {
            throw new IllegalArgumentException("Unavailable operation.");
        }
    }

    final private String expression_;
    final private int size_;
    private static int position_;
}
