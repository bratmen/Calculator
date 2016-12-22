package Garmash.task1.calculator.implementation;

/**
*The class Division implements the interface Operation
 */
public class Division implements Operation {
    @Override
    /**
    *This method overrides method interface and makes division 2 numbers
     */
    public double operationCalc(double valueA, double valueB) {
        return valueA / valueB;
    }
}
