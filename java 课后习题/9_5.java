
/*

GregorianCalender extend Calender
java.lang.Object ->java.util.Calendar ->java.util.GregorianCalendar 
*/

package exr;

import java.util.GregorianCalendar;

public class UseGregorianCalender {
    public static void main(String[] args) {
        GregorianCalendar obj=new GregorianCalendar();
        System.out.println(obj.get(GregorianCalendar.YEAR)+"."+(obj.get(GregorianCalendar.MONTH)+1)+"."+obj.get(GregorianCalendar.DAY_OF_MONTH));

        obj.setTimeInMillis(1234567898765L);

        System.out.println(obj.get(GregorianCalendar.YEAR)+"."+(obj.get(GregorianCalendar.MONTH)+1)+"."+obj.get(GregorianCalendar.DAY_OF_MONTH));


    }
}
