package oom;

/**
 * 栈溢出
 * <p>
 * -Xmx30m  -Xmn4m -Xss128K
 */
public class StackOverFlowTest {
    static int count = 0;

    static void aMethod() {
        System.out.println(count);
        count++;
        bMethod();
    }

    private static void bMethod() {
        System.out.println(count);
        count++;
        aMethod();
    }

    public static void main(String[] args) {
        aMethod();
    }
}
