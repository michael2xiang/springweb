package oom;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 堆外内存溢出
 * -Xmx30m  -Xmn4m -XX:MaxDirectMemorySize=50M  -XX:+UseG1GC -XX:G1HeapRegionSize=1024  -verbose:gc -Xlog:gc,gc+ref=debug,gc+heap=debug,gc+age=trace:file=/gc_%p.log:tags,uptime,time,level -Xlog:safepoint:file=/safepoint_%p.log:tags,uptime,time,level -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ -XX:ErrorFile=/hs_error_pid%p.log -XX:-OmitStackTraceInFastThrow
 */
public class OutHeapOOMTest {

    public static final int _1MB = 1024 * 1024;
    static List<ByteBuffer> byteList = new ArrayList<>();

    private static void oom(HttpExchange exchange) throws InterruptedException {
        try {
            String response = "oom begin";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; ; i++) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(_1MB);
            byteList.add(buffer);
            System.out.printf(i + "MB");
            memPrint();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
            }

        }

    }

    private static void memPrint() {
        for (MemoryPoolMXBean memoryPoolMXBean : ManagementFactory.getMemoryPoolMXBeans()) {
            System.out.printf(memoryPoolMXBean.getName() +
                    " commited:" + memoryPoolMXBean.getUsage().getCommitted()
                    + " used:" + memoryPoolMXBean.getUsage().getUsed() + "\n"
            );
        }
    }

    private static void srv() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8003), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(exchange -> {
            try {
                oom(exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        server.start();
    }

    public static void main(String[] args) throws Exception {
        srv();
    }
}
