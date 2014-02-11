
/**
 * Extends the abstract class StepByStepCalculator. A class to calculate an
 * arithmetic expression, step by step, according to the order of appearance,
 * from left to right, regardless of the parenthases.
 * 
 * @author lshaniv
 *
 */

public class QueueCalculator extends StepByStepCalculator {
	
    private boolean _isFirstIn;//determines if there are operands to calculate
	
    /**
     * Initialize the QueueCalculator
     */
	
    public QueueCalculator(){
        _listWrapper = new GeneralQueue();
        _isFirstIn = false;
    }
	
    /**
     * Get the next element in the expression. An element is an elementary
     * expression from the whole expression. It can be either a bracket
     * ("(" or ")"), an operator ("+", "-", "*" or "/") or a number with only
     * digits (no point or exponent). If it is time to evaluate part of the 
     * expression, return the elementary expression calcualted and its result. 
     * The format of the elementary calculation output should be of:
     * "[operand1][operator][operand2]=[result]" For example: "2*3=6" 
     * Queue mode remarks: 
     * 1) Ignore brackets in the expression. The order of calculation should 
     *    be the order of the operators (from left to right). 
     * 2) It is time to make an elementary calculation whenever a second 
     *    operand (number) arrives - which means that you should have 2 
     *    operands and an operator, and you can perform a caluculation.
     *    
     * @param nextElement the next element in the expression 
     * @return null if it is not yet time to evaluate an elementary 
     * expression, or the expression and its value, if it is time.
     */

    public String step(String nextElement) {
        if(_isFirstIn && isNumber(nextElement)){
            /*
             * if there is a first operand already in the Queue and the given
             * element is the second operand, it is time to calculate
             */
            return calcQueue(nextElement);
        }
        if(isOperator(nextElement) || isNumber(nextElement)){
            /*
             * otherwise - push the operator or the first operand to the Queue
             */
            if(isOperator(nextElement)){
                //operator is given - operand was already pushed to the Queue
                _isFirstIn = true;
            }
            _listWrapper.push(nextElement);
        }
        if(_listWrapper.size()==0){
            _isFirstIn = false;
        }
        return null;
    }
	
    /**
     * Calculating the expression represented by the given String and the
     * Queue, _listWrapper, and returns the arithmetical calculation 
     * represented by String.
     * @param element the second operand, represented by String
     * @return the arithmetical calculation represented by string
     */
	
    private String calcQueue(String element){
        //extracting the String to real double numbers in order to calculate
        Double help = new Double(element);
        double operand2 = help.doubleValue();
        help = new Double((String)_listWrapper.pop());
        double operand1 =  help.doubleValue();
        String operator = (String)_listWrapper.pop();
        double result = calc(operand1, operand2, operator);
        help = new Double(result);
        //pushing the result to the Queue
        _listWrapper.push(help.toString());
        //returning the arithmetical calculation as a String
        return formatDouble(operand1)+operator+formatDouble(operand2)+"="+
            formatDouble(result);
    }
}
