package bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 异常的字节码
 * finally的代码，会出现三份，
 * 1 try代码的末尾
 * 2 catch代码的末尾
 * 3 finally自己本身
 *
 * 编译器会自动加 any exception的捕获，默认的处理。
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
}
