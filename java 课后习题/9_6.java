import java.lang.System;

class StopWatch {
    private double startTime;
    private double endTime;

    void setStartTime(){
        startTime=System.currentTimeMillis();
    }
    void setSpotTime(){
        endTime=System.currentTimeMillis();
    }
    void getElapesedTime(){
        System.out.println((endTime-startTime)/1000+" seconds");
    }
}

public class Temp {
    public static void main(String[] args) {
        int[] array=new int[100000];
        int T;
        StopWatch obj=new StopWatch();

        for (int i = 0; i < array.length; i++) {
            array[i]= (int) (Math.random()*1000000);
        }
        obj.setStartTime();
        for(int i=0;i<array.length;i++) {
            for(int j=i;j<array.length;j++) {
                if(array[i]<=array[j]) {
                    T=array[j];
                    array[j]=array[i];
                    array[i]=T;
                }
            }
        }
        obj.setSpotTime();
        obj.getElapesedTime();
    }
}
