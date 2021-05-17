import java.util.Scanner;

public class FindFutureDate {
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            System.out.print("Enter today's day:");
            int today=input.nextInt();
            System.out.println();
            System.out.print("Enter the number of days elapsed since today:");
            int futureDay=input.nextInt();
            futureDay=(today+futureDay%7)%7;

            String[] Date={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

            System.out.println("Today is "+Date[today]+" and the future day is "+Date[futureDay]);
        }
}