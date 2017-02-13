package calculator;

/**
 * MS operation stores a value into the memory value.
 */
public class MSOperation implements UnaryOperationIf {
    MSOperation(Memory memory) {
        this.memory = memory;
    }

    public double execute(double value) {
        memory.store(value);
        return value;
    }

    private Memory memory;
}
