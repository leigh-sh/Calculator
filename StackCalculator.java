
/**
 * Extends the abstract class StepByStepCalculator. A class to calculate an
 * arithmetic expression, step by step, according to the order of the 
 * parenthases.
 * 
 * @author lshaniv
 *
 */

public class StackCalculator extends StepByStepCalculator {
	
    /**
     * Initialize the StackCalculator
     */
	
    public StackCalculator(){
        _listWrapper = new GeneralStack();
    }
	
    /**
     * Get the next element in the expression. An element is an elementary 
     * expression from the whole expression. It can be either a bracket 
     * ("(" or ")"), an operator ("+", "-", "*" or "/") or a number with only
     * digits (no point or exponent). If it is time to evaluate part of the
     * expression, return the elementary expression calcualted and its result.
     * The format of the elementary calculation output should be of: 
     * "[operand1][operator][operand2]=[result]" For example: "2*3=6" 
     * Stack mode remarks: 
     * 1) The order of calculation should be according to the brackets.
     * 2) It is time to make an elementary calculation whenever a closing 
     * bracket arrives - which means that you should have evaluated two 
     * subexpression into 2 numbers (the two preceding operands), and have
     * read the operator between them, so you can perform an elementary 
     * calculation.
     * 
     * @param nextElement the next element in the expression 
     * @return null if it is not yet time to evaluate an elementary 
     * expression, or the expression and its value, if it is time
     */

    public String step(String nextElement) {
        if(nextElement.equals(")")){
            //closing parenthesis is given - time to calculate
            return calcStack();
        }
        if(!nextElement.equals("(")){
            //if an operator or an operand is given: push to the Stack
            _listWrapper.push(nextElement);
        }
        return null;
    }
	
    /**
     * Calculating the expression in the head of the Stack _listWrapper, 
     * pushes the result to the head of the Stack, and returns the
     * arithmetical calculation, represented by String.
     * @return the arithmetical calculation represented by String
     */
	
    private String calcStack(){
        //extracting the String to real double numbers in order to calculate
        Double help = new Double((String)_listWrapper.pop());
        double operand2 = help.doubleValue();
        String operator = (String)_listWrapper.pop();
        help = new Double((String)_listWrapper.pop());
        double operand1 = help.doubleValue();
        double result = calc(operand1, operand2, operator);
        help = new Double(result);
        //pushing the result to the Stack
        _listWrapper.push(help.toString());
        //returning the arithmetical calculation as a String
        return formatDouble(operand1)+operator+formatDouble(operand2)+"="+
            formatDouble(result);
    }
}
