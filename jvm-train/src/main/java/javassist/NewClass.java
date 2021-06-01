package javassist;

import java.io.IOException;

/**
 * @author xiangzhenwen
 * @date 2021/6/1
 */
public class NewClass {

    public static void main(String[] args) throws CannotCompileException, IOException {
        final ClassPool cp = ClassPool.getDefault();
        final CtClass ctClass = cp.makeClass("Hello2");
        ctClass.writeFile("./log/out");

    }
}
