package asm;


import java.io.File;
import java.io.IOException;


import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;
import org.apache.commons.io.FileUtils;

import static org.springframework.asm.Opcodes.ASM7;

/**
 * @author xiangzhenwen
 * @date 2021/6/2
 */
public class ModifyMethod {
    public static void main(String[] args) throws IOException {
        final byte[] bytes = FileUtils.readFileToByteArray(new File("./log/out/Hello2.class"));

        ClassReader cr = new ClassReader(bytes);
        final ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        final ClassVisitor cv = new ClassVisitor(ASM7, cw) {
            @Override
            public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                if (!"foo".equals(name)) {
                    return mv;
                }
                return new AdviceAdapter(ASM7, mv, access, name, desc) {
                    @Override
                    protected void onMethodEnter() {
                        super.onMethodEnter();
                        this.mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        this.mv.visitLdcInsn(">>in");
                        this.mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                    }

                    @Override
                    protected void onMethodExit(final int i) {
                        super.onMethodExit(i);
                        this.mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
                        this.mv.visitLdcInsn("<<out");
                        this.mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
                    }
                };
            }
        };
        cr.accept(cv, 0);
        final byte[] bytesModify = cw.toByteArray();
        FileUtils.writeByteArrayToFile(new File("./log/out/Hello2.class"), bytesModify);


    }
}
