package javassist;

import java.io.IOException;

/**
 * @author xiangzhenwen
 * @date 2021/6/1
 */
public class AddMethodToClass {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException {
        final ClassPool cp = ClassPool.getDefault();

        cp.insertClassPath("./log/out");
        final CtClass ctClass = cp.get("Hello2");
        CtMethod method = new CtMethod(CtClass.intType,"foo",new CtClass[]{CtClass.intType,CtClass.intType},ctClass);
        method.setBody("return $1 + $2;");
        method.setModifiers(Modifier.PUBLIC);
        ctClass.addMethod(method);
        ctClass.writeFile("./log/out");


    }
}
