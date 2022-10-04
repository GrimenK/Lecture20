import org.testng.Assert;
import org.testng.annotations.*;

public class CalcTest {
    private Calculator calc = new Calculator();

    public void setCalc(int a, int b, char op){
        calc.setX(a);
        calc.setY(b);
        calc.setOperator(op);
    }

    @Test(priority = 1, groups = {"mainGroup"})
    private void firstTest(){
        setCalc(5,4,'-');
        double res = calc.calculateResult();
        Assert.assertEquals(res,1);
    }

    @Test(priority = 2,dataProvider = "testData", groups = {"mainGroup"})
    private void secondTest(int a, int b, char op){
        setCalc(a, b, op);
        double res = calc.calculateResult();
        Assert.assertNotEquals(res, 0);
    }

    @Test(priority = 3, dataProvider = "testData", groups = {"mainGroup"})
    private void thirdTest(int a, int b, char op){
        setCalc(a, b, op);
        double res = calc.calculateResult();
        Assert.assertTrue(res < 0);
    }

    @Test(priority = 4, groups = {"mainGroup"})
    @Parameters({"firstVal","secondVal"})
    private void fourthTest(int a, int b){
        setCalc(a, b, '+');
        double res = calc.calculateResult();
        Assert.assertEquals(res,225);
    }

    @Test(priority = 5, groups = {"mainGroup"})
    @Parameters({"firstVal","secondVal"})
    private void fifthTest(int a, int b){
        setCalc(a, b, '/');
        Assert.assertThrows(ArithmeticException.class, ()->calc.calculateResult());
    }

    @Test(priority = 6)
    @Parameters({"firstVal","secondVal"})
    private void sixthTest(int a, int b){
        setCalc(a, b, '*');
        double res = calc.calculateResult();
        Assert.assertNotEquals(res, 0);
    }

    @DataProvider(name = "testData")
    public Object[][] dataProvider(){
        return new Object[][] {{2,3,'*'},{5,-3,'/'}};
    }
}


