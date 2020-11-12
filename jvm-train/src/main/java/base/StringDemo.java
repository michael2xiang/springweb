package base;

public class StringDemo {
    public static void main(String[] args) {
        String s = new String("1"); //创建了2个对象，"1"字符串存储到常量池中； java heap中的String对象；
        String s2 = "1"; // 常量池中的内存地址
        String sPool = s.intern(); // 常量池中的内存地址
        System.out.println("s == s2 " + (s == s2)); //false
        System.out.println("s == sPool " + (s == sPool)); // false
        System.out.println("s2 == sPool " + (s2 == sPool)); // true

        System.out.println("--------------------");
        String s3 = new String("1") + new String("1"); // s3 是堆中的 "11"
        s3.intern(); // 常量池没有，常量池中为堆中s3地址
        String s4 = "11"; // 与s3一样了
        System.out.println("s3 == s4 " + (s3 == s4)); // true 因 s3.intern(); 后 常量池


        System.out.println("--------------------");
        String s5 = new String("1") + new String("1"); // s5 是堆中的 "11"
        String s6 = "11"; // 常量池没有，添加到常量池，返回新地址
        String s7 = s5.intern(); // 常量池已有，返回s6，但没接收赋值
        System.out.println("s5 == s6 " + (s5 == s6)); // false 因 s5是堆地址，s6是常量池新地址
        System.out.println("s7 == s6 " + (s7 == s6));
    }
}
