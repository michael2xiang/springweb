package bytecode;

interface ICustomClass{
    default void  iDefaultMethod(){}
    void  iMethod();
}

abstract  class  AbsCustomClass{
    abstract void absMethod();
}

/**
 * cd 到当前java文件目录
 *
 * java -jar F:\技术工具\asmtools-7.0.jar jdec InvokeDemo.class
 *
 * 编译
 * javac InvokeDemo.java
 *
 * 查看字节码
 * javap -p -v InvokeDemo.class
 */
public class InvokeDemo extends AbsCustomClass implements  ICustomClass {
    @Override
    public void iMethod() {

    }

    @Override
    void absMethod() {

    }

    static  void  staticMethod(){}
    private  void privateMethod(){}
    public void publicMethod(){}

    public static void main(String[] args) throws InterruptedException {
        InvokeDemo demo = new InvokeDemo();

        InvokeDemo.staticMethod();
        demo.privateMethod();
        demo.publicMethod();
        demo.iMethod();
        demo.absMethod();
        demo.iDefaultMethod();

        ((AbsCustomClass)demo).absMethod();
        ((ICustomClass)demo).iMethod();
        ((ICustomClass)demo).iDefaultMethod();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
