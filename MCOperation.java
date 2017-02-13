package calculator;

/**
 * MC operation cleans the memory value.
 */
public class MCOperation implements UnaryOperationIf {
    MCOperation(Memory memory) {
        this.memory = memory;
    }

    public double execute(double value) {
        memory.clear();
        return value;
    }

    private Memory memory;
}
