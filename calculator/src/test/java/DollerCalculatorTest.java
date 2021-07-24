
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) //junit사용하기 위해..
public class DollerCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000); //3000원을 리턴시키자
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi=new MarketApi();
        DollarCalculator dollarCalculator=new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator=new Calculator(dollarCalculator);
        System.out.println(calculator.sum(10,10));
        System.out.println(calculator.minus(10,10));

        Assertions.assertEquals(22000, calculator.sum(10,10)); //22000
        Assertions.assertEquals(0, calculator.minus(10,10)); //0
    }

    @Test
    public void mockTest(){
        DollarCalculator dollarCalculator=new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator=new Calculator(dollarCalculator);
        System.out.println(calculator.sum(10,10));
        System.out.println(calculator.minus(10,10));

        Assertions.assertEquals(60000, calculator.sum(10,10)); //22000
        Assertions.assertEquals(0, calculator.minus(10,10)); //0
    }
}
