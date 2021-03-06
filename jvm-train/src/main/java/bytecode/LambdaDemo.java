package bytecode;

/**
 * cd 到当前java文件目录
 * <p>
 * java -jar F:\技术工具\asmtools-7.0.jar jdec LambdaDemo.class
 * <p>
 * 编译
 * javac LambdaDemo.java
 * <p>
 * 查看字节码
 * javap -p -v LambdaDemo.class
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.printf("hi lambda");
        r.run();
        ;
    }
}
