import java.util.Random;

public class useRandom {
    public static void main(String[] args) {
        Random obj=new Random(1000);
        for (int i = 1; i < 51; i++) {
            System.out.print(obj.nextInt(100)+" ");
            if(i%5==0){
                System.out.println();
            }
        }

    }
}