import java.text.DecimalFormat;

class Stock {

    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    double change;
    String sign;

    void getChangePrice(){
        change=(currentPrice-previousClosingPrice)/previousClosingPrice;
        if(change>=0){
            sign="+";
        }else{
            sign="-";
        }
        change=Math.abs(change);
        UseApplyPatternMethodFormat();
    }

    Stock(String symbol,String name){
        this.name=name;
        this.symbol=symbol;
    }

    void setPrice(double previousClosingPrice,double currentPrice){
        this.previousClosingPrice=previousClosingPrice;
        this.currentPrice=currentPrice;
    }

    void UseApplyPatternMethodFormat() {
        String pattern="#.###%";
        DecimalFormat myFormat=new DecimalFormat();
        myFormat.applyPattern(pattern);
        System.out.println(this.sign+myFormat.format(change));

    }//void UseApplyPatternMethodFormat
}

public class Temp {
    public static void main(String[] args) {
        Stock obj=new Stock("ORCL","Oracle Corporation");
        obj.setPrice(34.5,34.35);
        obj.getChangePrice();
        obj.UseApplyPatternMethodFormat();
    }

}