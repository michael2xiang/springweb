package bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * 异常的字节码
 * finally的代码，会出现三份，
 * 1 try代码的末尾
 * 2 catch代码的末尾
 * 3 finally自己本身
 * <p>
 * 编译器会自动加 any exception的捕获，默认的处理。
 * <p>
 * javac ExceptionDemo.java
 * javap -p -v  ExceptionDemo.class
 */
public class ExceptionDemo {
    public void read() {
        InputStream in = null;
        try {
            in = new FileInputStream("a.java");
        } catch (FileNotFoundException e) {
            String a = "ffffffff";
//            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    String a = "eeeeeeeeeeeee";
//                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * finally 添加返回值
     * @param in
     * @return
     */
    public String finallyReturn(BigDecimal in) {
        try {
            return in.toString();
        } finally {
            return "2";
        }
    }

    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        String a = demo.finallyReturn(BigDecimal.ZERO);

        System.out.println(String.valueOf(a));
    }
}
