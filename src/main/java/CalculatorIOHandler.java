import java.util.Scanner;

import static java.lang.Float.NaN;

public class CalculatorIOHandler {
    private Calculator calculator;

    CalculatorIOHandler(Calculator calculator){
        this.calculator = calculator;
    }

    public void handleUserInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first digit: ");
        while (scanner.hasNext()) {
            if(scanner.hasNextInt()){
                calculator.setX(scanner.nextInt());
                break;
            }
            else {
                System.out.println("Please enter an integer");
                scanner.next();
            }
        }

        System.out.println("Enter operand, following operation are allowed - *, /, +, - :");
        while (scanner.hasNext()) {
            calculator.setOperator(scanner.next().charAt(0));
            if(calculator.getOperand() == '-' || calculator.getOperand()  == '*' || calculator.getOperand()  == '/' || calculator.getOperand()  == '+'){
                break;
            }
            else {
                System.out.println("Please enter valid operator");
                scanner.next();
            }
        }

        System.out.println("Enter second digit: ");
        while (scanner.hasNext()) {
            if(scanner.hasNextInt()){
                calculator.setY(scanner.nextInt());
                break;
            }
            else {
                System.out.println("Please enter an valid integer");
                scanner.next();
            }
        }
    }

    public void printResult(){
        double result = NaN;
        try {
            result = calculator.calculateResult();
        }
        catch (ArithmeticException e){
            System.out.println("Division by zero!!!!");
        }
        System.out.println(result);
    }
}
