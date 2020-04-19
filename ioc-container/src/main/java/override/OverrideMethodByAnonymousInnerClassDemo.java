package override;

/**
 * 匿名内部类重写父类的方法
 */
public class OverrideMethodByAnonymousInnerClassDemo {

    public static void main(String[] args) {
        //通过 anonymous inner class 匿名内部类重写父类的方法，可以不加 @Override 标记
        ParentClass parentClass = new ParentClass() {
            protected String get() {
                return "OverrideDemo---";

            }
        };
        System.out.println(parentClass.get());
    }
}
