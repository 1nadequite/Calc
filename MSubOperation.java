package calculator;

/**
 * M- operation subtracts a value from the memory value.
 */
public class MSubOperation implements UnaryOperationIf {
    MSubOperation(Memory memory) {
        this.memory = memory;
    }

    public double execute(double value) {
        memory.subtract(value);
        return value;
    }

    private Memory memory;
}
