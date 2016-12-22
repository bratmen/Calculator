package Garmash.task1.calculator;

import Garmash.task1.calculator.implementation.ExpressionEvaluation;

import java.util.Scanner;

/**
*Class Calculate have a main method
 */
public class Calculate {
    /**
     *Method main reads the entered text line, it calculates the value and returns the result
     */
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            ExpressionEvaluation calculate = new ExpressionEvaluation();
                System.out.println("Input String type 2*4-5+(4,6+8,9)-14");
                String string = scanner.nextLine();
            try {
                if(calculate.testString(string)) {
                    System.out.println(calculate.evaluation(string));
                } else System.out.println("Error");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Would you like to start over? (yes,no)");
            String startOver = scanner.nextLine();
            if ("no".equals(startOver)) {
                run = false;
                System.out.print("Bye");
            }
        }
    }
}