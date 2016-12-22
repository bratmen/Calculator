package Garmash.task1.calculator.implementation;

/**
*The class Addition implements the interface Operation
 */
public class Addition implements Operation {
    @Override
    /**
    *This method overrides method interface and makes addition 2 numbers
     */
    public double operationCalc(double valueA, double valueB) {
        return valueA + valueB;
    }
}
