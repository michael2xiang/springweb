package traindemo;

//https://www.cnblogs.com/Kidezyq/p/8040338.html

public class StringIntern {
    public static void main(String[] args) {
        String s1 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}
