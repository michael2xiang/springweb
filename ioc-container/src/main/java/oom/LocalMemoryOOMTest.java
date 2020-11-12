package oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本地内存溢出，jmap 命令查看，内存使用量很少
 * 操作系统，查看进程内存，不断增大
 */
public class LocalMemoryOOMTest {
    public static void main(String[] args) throws IllegalAccessException {
        Field field = Unsafe.class.getDeclaredFields()[0];
        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);

        while (true) {
            unsafe.allocateMemory(1024 * 1024);
        }
    }
}
