package bytecode;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xiangzhenwen
 * @date 2021/5/18
 */
public class AllInOneDemo {
    public int addPublic(int a, int b) {
        return a + b;
    }

    public int calPublic(int a, int b, int c, int d) {
        return (a * b) + (b * d);
    }

    private int addPrivate(int a, int b) {
        return a + b;
    }

    public final boolean control(int a) {
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean control2(int a) {
        return a > 0 ? true : false;
    }

    public int forDemo(int a) {
        int sum = 0;
        for (int i = 0; i < a; i++) {
            sum = sum + i;
        }
        return sum;
    }


    public Integer foreachDemo(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        return sum;
    }

    public void tryCatchFinally() {
        try {
            this.tryFun();
        } catch (Exception ex) {
            this.catchFun();
        } finally {
            this.finallyFun();
        }
    }

    public void closeResource() throws IOException {
        FileOutputStream in = null;
        try {
            in = new FileOutputStream("test.txt");
            in.write(1);
        } finally {
            if (in != null) {
                //如果 write, close 都抛异常，根据finally作用，就只能收到 close 的异常
                in.close();
            }
        }
    }

    public void closeResource2() throws IOException {
        FileOutputStream in = null;
        Exception tmpException = null;
        try {
            in = new FileOutputStream("test.txt");
            in.write(1);
        } catch (Exception e) {
            tmpException = e;
            throw e;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e2) {
                    if (tmpException != null) {
                        e2.addSuppressed(tmpException);
                    }
                }
            }
        }
    }

    public void tryWithResource() throws IOException {
        try (FileOutputStream in = new FileOutputStream("test.txt")) {
            in.write(1);
        }
    }



    private void finallyFun() {
    }

    private void catchFun() {

    }

    private void tryFun() {

    }

    public static void main(String[] args) {
        AllInOneDemo demo = new AllInOneDemo();
        demo.addPublic(1, 2);
        demo.calPublic(1, 2, 3, 4);
        demo.addPrivate(1, 2);
        demo.control(1);
        demo.control2(1);
        demo.forDemo(3);
    }
}
