package oom;

import com.sun.management.OperatingSystemMXBean;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * 堆外内存泄漏demo，熟悉排查工具使用
 *
 * 启动参数
 * java -Xmx1G -Xmn1G -XX:+AlwaysPreTouch  -XX:MaxMetaspaceSize=10M -XX:MaxDirectMemorySize=10M -XX:NativeMemoryTracking=detail LeakExample
 */
public class OutHeapOom {

    static volatile int maxMem = 60;

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8881), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(exchange -> {
            try {
                maxMem = 85;
                String response = "ok";
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream outputStream = exchange.getResponseBody();
                outputStream.write(response.getBytes());
                outputStream.close();
            } catch (Exception ex) {
            }

        });
        server.start();

        int block_size = 1024;
        String str = randomString(block_size / Byte.SIZE);
        byte[] bytes = compress(str);
        for (; ; ) {
            int precent = memoryLoad();
            if (precent > maxMem) {
                Thread.sleep(1000);
            } else {
                decompress(bytes);
                Thread.sleep(1);
            }

        }


    }

    public static int copy(InputStream input, OutputStream output) throws IOException {
        long count = copyLarge(input, output);
        return count > 2147483647L ? -1 : (int) count;
    }

    private static long copyLarge(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];
        long count = 0L;
        int n;
        for (; -1 != (n = input.read(buffer)); count += (long) n)
            output.write(buffer, 0, n);

        return count;
    }

    private static String decompress(byte[] inputBytes) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(new GZIPInputStream(new ByteArrayInputStream(inputBytes)), out);
        return new String(out.toByteArray());

    }

    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

    private static int memoryLoad() {
        double totalVirtualMemory = osmxb.getTotalPhysicalMemorySize();
        double freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();

        double value = freePhysicalMemorySize / totalVirtualMemory;
        int percent = (int) ((1 - value) * 100);
        return percent;
    }

    private static byte[] compress(String str) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        try {
            gzip.write(str.getBytes());
            gzip.finish();
            byte[] b = bos.toByteArray();
            return b;
        } finally {
            gzip.close();
            bos.close();
        }
    }

    private static String randomString(int strLength) {
        Random rnd = ThreadLocalRandom.current();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strLength; i++) {
            boolean isChar = (rnd.nextInt(2) % 2 == 0);
            if (isChar) {
                int choice = rnd.nextInt(2) % 2 == 0 ? 65 : 97;
                sb.append((choice + rnd.nextInt(26)));

            } else {
                sb.append(rnd.nextInt(10));
            }
        }
        return sb.toString();
    }
}
