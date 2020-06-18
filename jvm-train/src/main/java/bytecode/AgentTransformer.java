package bytecode;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class AgentTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className,
                            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.endsWith("MainRunDemo")) {
            try {
                String loadName = className.replaceAll("/", ",");
                CtClass ctClass = ClassPool.getDefault().get(loadName);
                CtMethod ctMethod = ctClass.getDeclaredMethod("abc");
                ctMethod.addLocalVariable("_startTime", CtClass.longType);
                ctMethod.insertBefore("_startTime = System.nanoTime();");
                ctMethod.insertAfter("System.out.println(System.nanoTime() - _startTime);");
                System.out.println(className);
                return ctClass.toBytecode();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
