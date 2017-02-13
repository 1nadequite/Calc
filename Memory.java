package calculator;

/**
 * Class memory implements block of memory with following operations:
 * - clear the memory value;
 * - store a value into the memory value;
 * - recall the memory value;
 * - add a value to the memory value;
 * - subtract a value from the memory value.
 */
public class Memory {
    Memory() {
        value = 0.0;
    }

    public void clear() {
        value = 0;
    }
    public void store(double value) {
        this.value = value;
    }
    public double recall() { return value; }
    public void addition(double value) { this.value += value; }
    public void subtract(double value) {
        this.value -= value;
    }

    private double value;
}
