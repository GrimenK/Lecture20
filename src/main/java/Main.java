
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        CalculatorIOHandler calculatorIOHandler = new CalculatorIOHandler(calculator);
        calculatorIOHandler.handleUserInput();
        calculatorIOHandler.printResult();

        System.out.println();
    }


}
