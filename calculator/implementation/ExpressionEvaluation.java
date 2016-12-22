package Garmash.task1.calculator.implementation;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*Class ExpressionEvaluation has methods by which the calculation is entered expression
 */
public class ExpressionEvaluation {
    /**
    *Method isDelim takes as input a character and returns the space character
     */
       private boolean isDelim(char c) {
            return c == ' ';
        }
    /**
    *Method isOperator takes as input a character and returns + or - or * or /
     */
       private boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
    /**
    *Method priority receives a character input and returns a number equal to the priority of the operation
     */
       private int priority(char operation) {
            switch (operation) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                default:
                    return -1;
            }
        }
    /**
     *Method processOperator takes as input a list of arguments,
     *the sign of the operation and returns the result of a simple calculation
     */
    private void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        Operation operation = null;
        switch (op) {
            case '+':
                operation = new Addition();
                st.add(operation.operationCalc(l,r));
                break;
            case '-':
                operation = new Subtraction();
                st.add(operation.operationCalc(l,r));
                break;
            case '*':
                operation = new Multiplication();
                st.add(operation.operationCalc(l,r));
                break;
            case '/':
                operation = new Division();
                st.add(operation.operationCalc(l,r));
                break;
        }
    }
    /**
    *Method evaluation converts the resulting string to the entrance of the RPN, computes and returns the result
     */
    public double evaluation(String s) {
        LinkedList<Double> st = new LinkedList<Double>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }
    /**
    *Method testString gets the string at the input checks that it is correctly input and returns a true or false
     */
        public boolean testString(String testString) throws Exception{
            Pattern pattern = Pattern.compile("^([(]?+(\\d+(?:[\\.]\\d)?)+[-+*\\/]{1}+[(]?+(\\d+(?:[\\.]\\d)?)+[)]?+([-+*\\/]{1}+[(]?+(\\d+(?:[\\.]\\d)?)+[)]?+)*)+[=]?$");
            Matcher matcher = pattern.matcher(testString);

            if (!matcher.matches()){
               throw new Exception();
            }
            return true;
        }

    }
