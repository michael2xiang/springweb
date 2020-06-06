package bytecode;

/**
 * 锁的字节码
 *
 * 编译
 * javac LockByteCode.java
 *
 * 查看字节码
 * javap -p -v LockByteCode.class
 */
public class LockByteCode {
    /**
     * 实例方法，对this加锁
     */
    synchronized void syncMethod() {
        System.out.printf("syncMethod");
    }

    /**
     * 静态方法，对class加锁
     */
    static synchronized void syncStaticMethod() {
        System.out.printf("syncStaticMethod");
    }

    final Object lock = new Object();

    /**
     * 自定义锁
     */
    void doLock() {
        synchronized (lock) {
            System.out.printf("doLock");
        }
    }


}
