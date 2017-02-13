package calculator;

/**
 * M+ operation addictions a value to the memory value.
 */
public class MAddOperation implements UnaryOperationIf {
    MAddOperation(Memory memory) {
        this.memory = memory;
    }

    public double execute(double value) {
        memory.addition(value);
        return value;
    }

    private Memory memory;
}
