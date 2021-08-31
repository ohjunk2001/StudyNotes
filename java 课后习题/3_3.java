import java.util.Scanner;

public class SolveLinearEquation {
    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);
        System.out.print("Enter a, b, c, d, f:");
        double a=input.nextDouble();
        double b=input.nextDouble();
        double c=input.nextDouble();
        double d=input.nextDouble();
        double e=input.nextDouble();
        double f=input.nextDouble();

        double discriminant=a*d-b*c;
        if(discriminant==0){
            System.out.println("The equation has no solution");
        }
        else {
            double x = (e * d - b * f) / (a * d - b * c);
            double y = (a * f - e * c) / (a * d - b * c);

            System.out.println("x is " + x + " and y is " + y);
        }
    }
}