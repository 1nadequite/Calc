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
                prevValue = nextValue;
                return nextValue;
            } else if (cur_char == '+' || cur_char == '-' || cur_char == '/' || cur_char == '*' ||
                       cur_char == '^' || cur_char == '√' || cur_char == '(' || cur_char == ')') {
                nextValue += cur_char;
                if ((prevValue == null || prevValue.equals("(")) && nextValue.equals("-")) {
                    prevValue = nextValue;
                    continue;
                }
                prevValue = nextValue;
                position_++;
                break;
            } else if (cur_char == 's' || cur_char == 'c') {
                for (int i = 0; i < 3; ++i) {
                    nextValue += expression_.charAt(position_);
                    position_++;
                }
                prevValue = nextValue;
                break;
            } else {
                continue;
            }
        }
        return (nextValue.isEmpty()) ? null : nextValue;
    }

    final private String expression_;
    final private int size_;
    private static int position_;
    private static String prevValue;
}
