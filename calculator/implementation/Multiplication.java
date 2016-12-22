package Garmash.task1.calculator.implementation;

/**
*The class Multiplication implements the interface Operation
 */
public class Multiplication implements Operation {
    @Override
    /**
    *This method overrides method interface and makes multiplication 2 numbers
     */
    public double operationCalc(double valueA, double valueB) {
        return valueA * valueB;
    }
}
