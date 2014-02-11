import java.util.Scanner;
import intro.ex11.ExpressionParser;

/**
 * A driver: The calculator. The user enters an expression to evaluation.
 * This calculator uses StepByStepCalculators, feads them with the elements 
 * of the expression (Strings) and prints the elementary calculations of the 
 * process - each elementary calculation in a new line, until the elements of 
 * the expression finish.
 * The calculator uses ExpressionParser to parse the expression given by the 
 * user to elements that will be fed to the StepByStepCalculators.
 * 
 * The calculator should:
 * 0) Wait for an input from the user (the input should be an expression to
 * evaluate). When given an expression, this calculator:
 * 1) Displays the expression in a new line.
 * 2) Prints a headline "*************** mode 1:"
 * 3) Feeds the elements to a StackCalculator, and prints the elementary
 *    calculations it gets, each in a new line.
 * 4) Prints a headline "*************** mode 2:"
 * 5) Feeds the elements to a QueueCalculator, and prints the elementary 
 * calculations it gets, each in a new line.
 * 6) Prints a delimiting line "------------------------------".
 * 7) Repeat steps 0-6, until either:
 * a) The input from the user has illegal characters, in which case the
 *    ExpressionParser should handle it with an error message and exit the
 *    program.
 * b) The user interupted the run with ctrl+c. 
 * 
 * @author lshaniv
 *
 */

public class Calculator {
	
    /**
     * The main method of Calculator.
     * 
     * @param args
     */
	
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){ //will stop when input is illegal or user presses ctrl+c
            String expression = sc.nextLine();
            System.out.println(expression);	
            stackExp(expression);
            queueExp(expression);
            System.out.println("------------------------------");
        }
    }
	
    /**
     * Calculating the given expression with a StackCalculator and printing 
     * each arithmetical calculation in a new line.
     * 
     * @param expression the given expression
     */
	
    private static void stackExp(String expression){
        StackCalculator stack = new StackCalculator();
        ExpressionParser e = new ExpressionParser(expression);
        String s;
        System.out.println("*************** mode 1:");
        String line;
        do{
            s=e.getNextElement();
            if(s!=null){
                line = stack.step(s);
                if(line!=null){
                    //printing only aritmetical calculations
                    System.out.println(line);
                }
            }
        }
        while(s!=null);
    }
	
    /**
     * Calculating the given expression with a QueuekCalculator and printing 
     * each arithmetical calculation in a new line.
     * 
     * @param expression the given expression
     */
	
    private static void queueExp(String expression){
        QueueCalculator queue = new QueueCalculator();
        ExpressionParser e = new ExpressionParser(expression);
        String s;
        System.out.println("*************** mode 2:");
        String line;
        do{
            s=e.getNextElement();
            if(s!=null){
                line = queue.step(s);
                if(line!=null){
                    //printing only aritmetical calculations
                    System.out.println(line);
                }
            }
        }
        while(s!=null);
    }
}
