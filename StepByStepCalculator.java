import java.text.DecimalFormat;

/**
 * A calculator that works step by step to evaluate an arithmetic expression,
 * during reading the expression from left to right.
 * 
 * @author lshaniv
 */

public abstract class StepByStepCalculator {

    /**
     * This will help formating the double values
     */
    private static DecimalFormat _decimalFormat = 
        new DecimalFormat("#.##");

    /**
     * A linked list wrapper that will help manage the data for the calculation
     */
    protected LinkedListWrapper _listWrapper;
    
    /**
     * Get the next element in the expression.
     * An element is an elementary expression from the whole expression.
     * It can be either a bracket ("(" or ")"),
     * an operator ("+", "-", "*" or "/") 
     * or a number with only digits (no point or exponent).
     * If it is time to evaluate part of the expression,
     * return the elementary expression calcualted and its result.
     * The format of the elementary calculation output should be of:
     * "[operand1][operator][operand2]=[result]"
     * For example:
     * "2*3=6"
     * @param nextElement the next element in the expression
     * @return null if it is not yet time to evaluate an elementary expression,
     * or the expression and its value, if it is time.
     */
    
    public abstract String step(String nextElement);

    /**
     * Format the double value to be represented with 2 digits after
     * the floating point.
     * @param number the double value
     * @return the string representation of the double, in the required format
     */
    
    public static String formatDouble(double number) {
        return _decimalFormat.format(number);
    }
    
    /**
     * Returns true iff the given String is a number, assuming that the input
     * is legal.
     * @param element the given String
     * @return true iff the given String is a number
     */
    
    protected boolean isNumber(String element){
        return(!element.equals("(") && !element.equals(")") &&
                                      !isOperator(element));
    }
	
    /**
     * Returns true iff the given String is an operator, assuming legal input.
     * @param element the given String
     * @return true iff the given String is an operator
     */
	
    protected boolean isOperator(String element){
        return (element.equals("+") || element.equals("-") || 
                element.equals("*") || element.equals("/"));
    }
	
    /**
     * Returns the result of the given arithmetical operation between operand1
     * and operand2.
     * @param operand1 first given operand
     * @param operand2 second given operand
     * @param operator given arithmetical operation
     * @return the result of the given arithmetical operation between operand1
     * and operand2
     */
	
    protected double calc(double operand1, double operand2, String operator){
        double result=0;
        if(operator.equals("+")){
            result = operand1+operand2;
        }
        if(operator.equals("-")){
            result = operand1-operand2;
        }
        if(operator.equals("*")){
            result = operand1*operand2;
        }
        if(operator.equals("/")){
            result = operand1/operand2;
        }
        return result;
    }
}
