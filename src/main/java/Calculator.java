import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Float.NaN;

public class Calculator implements CalculationPerformer {

    private int x;
    private int y;
    private char operand;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public char getOperand(){
        return operand;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setOperator(char operand){
        this.operand = operand;
    }

    public double calculateResult(){
        switch (operand) {
            case '+':
                return x+y;
            case '-':
                return x-y;
            case '*':
                return x*y;
            case '/':
                try{
                return x / y;}
                catch (ArithmeticException e){
                    throw e;
                }
            default:
                return NaN;
        }
    }

}
