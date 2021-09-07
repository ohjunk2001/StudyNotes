# Arrays类

Arrays 类位于 java.util 包中，主要包含了操纵数组的各种方法

使用时导包:`import java.util.Arrays;`

## 1. 排序

Arrays工具类提供了一个sort方法，只需要一行代码即可完成排序功能。
```
import java.util.Arrays;
public class temp {

	public static void main(String[] args) {
		int[] a=new int[6];
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*100);
		}
		
		String content=Arrays.toString(a);
		System.out.println(content);
		Arrays.sort(a);
		content=Arrays.toString(a);
		System.out.println(content);

	}

}
```
运行结果
```
[1, 33, 71, 37, 66, 95]
[1, 33, 37, 66, 71, 95]
```

## 2. 搜索 binarySearch
查询元素出现的位置，注意，在查询前必须先使用sort排序，另外如果数组中有多个相同的元素，那么查询的结果是不准确的,返回的位置是重复元素的第一个位置。
```
import java.util.Arrays;
import java.util.Scanner;
public class temp {

	public static void main(String[] args) {
		int[] a=new int[20];
		int values;
		Scanner input=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*100);
		}
		String content=Arrays.toString(a);
		System.out.println(content);
		Arrays.sort(a);
		content=Arrays.toString(a);
		System.out.println(content);
		System.out.println("输入你想要查询的元素：");
		int temp=input.nextInt();
		System.out.println(Arrays.binarySearch(a, temp));

	}

}
```

运行结果
```
[63, 14, 4, 5, 18, 51, 51, 54, 46, 72, 73, 78, 72, 32, 81, 74, 72, 77, 39, 50]
[4, 5, 14, 18, 32, 39, 46, 50, 51, 51, 54, 63, 72, 72, 72, 73, 74, 77, 78, 81]
输入你想要查询的元素：
46
6
```

## 3. 将数组转换成字符串

如果要打印一个数组的内容，就需要通过for循环来挨个遍历，逐一打印

但是Arrays提供了一个toString()方法，直接把一个数组，转换为字符串，这样方便观察数组的内容
```
import java.util.Arrays;
public class temp {

	public static void main(String[] args) {
		int[] a=new int[] {1,2,3,4,5,6};
		String content=Arrays.toString(a);
		System.out.println(content);

	}

}
```
运行结果
```
[1, 2, 3, 4, 5, 6]
```

## 4. 复制数组

数组的长度是不可变的，一旦分配好空间，是多长，就多长，不能增加也不能减少

**for循环复制**

```java
public class HelloWorld {
    public static void main(String[] args) {
        int a [] = new int[]{18,62,68,82,65,9};
         
        int b[] = new int[3];//分配了长度是3的空间，但是没有赋值
         
        //通过数组赋值把，a数组的前3位赋值到b数组
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
    }
}
```

**System.arraycopy方法复制**

把一个数组的值，复制到另一个数组中

 ```java
System.arraycopy(src, srcPos, dest, destPos, length)
 ```

- src: 源数组
- srcPos: 从源数组复制数据的起始位置
- dest: 目标数组
- destPos: 复制到目标数组的起始位置
- length: 复制的长度

```java
public class HelloWorld {
    public static void main(String[] args) {
        int a [] = new int[]{18,62,68,82,65,9};
         
        int b[] = new int[3];//分配了长度是3的空间，但是没有赋值
         
        //通过数组赋值把，a数组的前3位赋值到b数组    
        System.arraycopy(a, 0, b, 0, 3);
         
        //把内容打印出来
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
 
    }
}
```



## 5. 判断是否相同

比较两个数组的内容是否一样,使用equals()方法
```java
import java.util.Arrays;
import java.util.Scanner;
public class temp {

	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,4,5};
		int[] b=new int[]{1,2,3,4,3};
		System.out.println(Arrays.equals(a,b));
	}

}
```

运行结果
```
false
```

## 6. 填充
使用同一个值填充整个数组
```java
import java.util.Arrays;
public class temp {

	public static void main(String[] args) {
		int[] a=new int[9];
		Arrays.fill(a, 5);
		System.out.println(Arrays.toString(a));
	}

}
```