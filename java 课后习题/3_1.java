import java.util.Scanner;

public class SolveEquation {
    public static void main(String[] args) {
        double a,b,c;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a, b, c:");
        a=input.nextDouble();
        b=input.nextDouble();
        c=input.nextDouble();
        double discriminant=b*b-4*a*c;
        if(discriminant>0){
            double x1=(-b+discriminant)/(2*a);
            double x2=(-b-discriminant)/(2*a);
            System.out.println("The equation has two roots: "+x1+" and "+x2);
        }else if(discriminant==0){
            double x=-b/(2*a);
            System.out.println("The equation has one root: "+x);
        }else {
            System.out.println("The equation has no solution.");
        }

    }
}