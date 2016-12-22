package Garmash.task1.calculator.implementation;

/**
*The class Subtraction implements the interface Operation
 */
public class Subtraction implements Operation {
    @Override
    /**
    *This method overrides method interface and makes subtraction 2 numbers
     */
    public double operationCalc(double valueA, double valueB) {
        return valueA - valueB;
    }
}
