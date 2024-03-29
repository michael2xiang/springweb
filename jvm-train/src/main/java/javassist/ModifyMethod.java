package javassist;

import java.io.IOException;

/**
 * @author xiangzhenwen
 * @date 2021/6/1
 */
public class ModifyMethod {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        final ClassPool cp = ClassPool.getDefault();
        cp.insertClassPath("./log/out");

        final CtClass ctClass = cp.get("Hello2");
        final CtMethod foo = ctClass.getMethod("foo", "(II)I");
        foo.insertBefore("System.out.println(\">>in\");");
        foo.insertAfter("System.out.println(\"<<out\");");
        ctClass.writeFile("./log/out");
    }
}
