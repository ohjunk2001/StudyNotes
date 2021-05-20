```java
class Rectangle {
    double width=1;
    double height=1;

    Rectangle(){

    }
    Rectangle(double width,double height){
        this.height=height;
        this.width=width;
    }

    double getArea(){
        double area=height*width;
        return area;
    }
    double getPerimeter(){
        double meter=2*(height+width);
        return meter;
    }

}
```


test program

```java
public class Temp {
    public static void main(String[] args) {
        Rectangle obj1=new Rectangle(4,40);
        Rectangle obj2=new Rectangle(3.5,35.9);
        System.out.println("obj1");
        System.out.println(obj1.getArea());
        System.out.println(obj1.getPerimeter());

        System.out.println("obj2");
        System.out.println(obj2.getArea());
        System.out.println(obj2.getPerimeter());

        
    }

}
```

