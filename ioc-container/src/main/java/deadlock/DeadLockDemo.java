package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程死锁例子，使用命令 jstack -l pid 查询线程执行栈能显出死锁信息
 */
public class DeadLockDemo {
    private static Lock lockA = new ReentrantLock();
    private static Lock lockB = new ReentrantLock();

    public static void run()
    {
        Thread tA = new Thread(() -> {
            try {
                lockA.lock();
                Thread.sleep(1000);
                lockB.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread tB = new Thread(()->{
            try {
                lockB.lock();
                Thread.sleep(1000);
                lockA.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tA.setName("tAAAAAAAAAAA");
        tB.setName("tBBBBBBBBBBB");
        tA.start();
        tB.start();

    }

    public static void main(String[] args) {
        run();
    }

}
