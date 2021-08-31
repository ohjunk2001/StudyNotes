import java.util.Scanner;

public class addtion {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int num1=(int)(System.currentTimeMillis()%10);
        int num2=(int)(Math.random()*10);
        int num3=(int)(Math.random()*10);
        boolean sign;

        System.out.println("What is "+num1+" + "+num2+" + "+num3+"?");
        System.out.print("Your answer:");
        int result=input.nextInt();
        if(num1+num2+num3==result){
            sign=true;
        }else{
            sign=false;
        }

        System.out.print(num1+" + "+num2+" + "+num3+"="+result+" is "+sign);


    }
}