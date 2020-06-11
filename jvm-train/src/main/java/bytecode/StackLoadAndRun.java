package bytecode;

class B {
    private int a = 1234;
    static long C = 1111;
    public long test(long num) {
        long ret = this.a + num + C;
        return ret;
    }
}

/**
 * javac -g:lines -g:vars StackLoadAndRun.java
 * javap -p -v StackLoadAndRun
 * javap -p -v B
 */
public class StackLoadAndRun {
    private B b = new B();
    public static void main(String[] args) {
        StackLoadAndRun a = new StackLoadAndRun();
        long num = 4321;

        long ret = a.b.test(num);

        System.out.println(ret);
    }
}
