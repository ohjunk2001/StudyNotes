# System.in

System.out 是常用的在控制台输出数据的

System.in 可以从控制台输入数据

## System.in

```java
package stream;

import java.io.IOException;
import java.io.InputStream;

public class TestStream {

	public static void main(String[] args) {
		// 控制台输入
		try (InputStream is = System.in;) {
			while (true) {
				// 敲入a,然后敲回车可以看到
				// 97 13 10
				// 97是a的ASCII码
				// 13 10分别对应回车换行
				int i = is.read();
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

```

## System.in

```java
package stream;
 
import java.io.IOException;
import java.io.InputStream;
 
public class TestStream {
 
    public static void main(String[] args) {
        // 控制台输入
        try (InputStream is = System.in;) {
            while (true) {
                // 敲入a,然后敲回车可以看到
                // 97 13 10
                // 97是a的ASCII码
                // 13 10分别对应回车换行
                int i = is.read();
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Scanner 读取字符串

使用 System.in.read 虽然可以读取数据，但是很不方便

使用 Scanner 就可以逐行读取了

```java
package stream;
    
import java.util.Scanner;
    
public class TestStream {
    
    public static void main(String[] args) {
         
            Scanner s = new Scanner(System.in);
             
            while(true){
                String line = s.nextLine();
                System.out.println(line);
            }
         
    }
}
```

## Scanner 从控制台读取整数

使用 Scanner 从控制台读取整数

```java
package stream;

import java.util.Scanner;

public class TestStream {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		System.out.println("第一个整数："+a);
		int b = s.nextInt();
		System.out.println("第二个整数："+b);
	}
}
```