public class DollarCalculator implements ICalculator{

    private int price=1; //기본은 1이고 달러의 시세가치..
    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi){
        this.marketApi=marketApi;
    }

    public void init(){
        this.price= marketApi.connect(); //초기화
    }

    @Override
    public int sum(int x, int y) {
        x*=price;
        y*=price;
        return x+y;
    }

    @Override
    public int minus(int x, int y) {
        x*=price;
        y*=price;
        return x-y;
    }
}
