package bytecode;

public class BoxDemo {
    public Integer cal() {
        Integer a = 100;
        int b = a + 9;
        return b;
    }


    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;


        //初始化是用 Integer.valueOf 里面有缓存，提前初始化好[-128,127]的包装类型，
        // 127是默认值，可在启动参数中配置：-XX:AutoBoxCacheMax=256
        // i1，i2都是用缓存中的同一个对象，引用（内存地址）是一样的
        // i3，i4都是新实例化的对象，引用不用；
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        //对象类型判断值用equals
        System.out.println(i1.equals(i2));
        System.out.println(i3.equals(i4));


        Integer i5 = new Integer(127);
        Integer i6 = new Integer(127);
        System.out.println(i5 == i6);


    }

}
