package mat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Objects4MAT {
    static class A4MAT {
        B4MAT b4MAT = new B4MAT();
    }

    static class B4MAT {
        C4MAT c4MAT = new C4MAT();
    }

    static class C4MAT {
        List<String> list = new ArrayList<>();
    }

    static class DominatorTreeDemo1 {
        DominatorTreeDemo2 dominatorTreeDemo2;

        public void setValue(DominatorTreeDemo2 value) {
            this.dominatorTreeDemo2 = value;
        }
    }

    static class DominatorTreeDemo2 {
        DominatorTreeDemo1 dominatorTreeDemo1;

        public void setValue(DominatorTreeDemo1 value) {
            this.dominatorTreeDemo1 = value;
        }
    }

    static class Holder {
        DominatorTreeDemo1 demo1 = new DominatorTreeDemo1();
        DominatorTreeDemo2 demo2 = new DominatorTreeDemo2();

        Holder() {
            demo1.setValue(demo2);
            demo2.setValue(demo1);
        }

        private boolean aBoolean = false;
        private char aChar = '\0';
        private short aShort = 1;
        private int anInt = 1;
        private long aLong = 1L;
        private float aFloat = 1.0F;
        private double aDouble = 1.0D;
        private Double aDouble_2 = 1.0D;
        private int[] ints = new int[2];
        private String string = "1234";
    }

    Runnable runnable = () -> {
        Map<String, A4MAT> map = new HashMap<>();

        IntStream.range(0, 100).forEach(i -> {
            byte[] bytes = new byte[1024 * 1024];
            String str = new String(bytes).replace('\0', (char) i);
            A4MAT a4MAT = new A4MAT();
            a4MAT.b4MAT.c4MAT.list.add(str);

            map.put(i + "", a4MAT);
        });

        Holder holder = new Holder();

        try {
            //sleep forever , retain the memory
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    void startHugeThread() throws Exception {
        new Thread(runnable, "huge-thread").start();
    }

    public static void main(String[] args) throws Exception {
        Objects4MAT objects4MAT = new Objects4MAT();
        objects4MAT.startHugeThread();
    }
}
