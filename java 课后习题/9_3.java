package exr;

import java.util.Date;

public class useDate {
    public static void main(String[] args) {
        Date obj=new Date();

        obj.setTime(10000);
        System.out.println(obj.toString());

        obj.setTime(100000);
        System.out.println(obj.toString());
        obj.setTime(1000000);
        System.out.println(obj.toString());
        obj.setTime(10000000);
        System.out.println(obj.toString());
        obj.setTime(100000000);
        System.out.println(obj.toString());
        obj.setTime(1000000000);
        System.out.println(obj.toString());
        obj.setTime(1000000000);
        System.out.println(obj.toString());
    }
}
