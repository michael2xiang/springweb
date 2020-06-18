package oom;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * 元空间内存溢出
 * <p>
 * -Xmx20m  -Xmn4m -XX:+UseG1GC  -verbose:gc -Xlog:gc,gc+ref=debug,gc+heap=debug,gc+age=trace:file=/gc_%p.log:tags,uptime,time,level -Xlog:safepoint:file=/safepoint_%p.log:tags,uptime,time,level -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ -XX:ErrorFile=/hs_error_pid%p.log -XX:-OmitStackTraceInFastThrow -XX:MetaspaceSize=16M -XX:MaxMetaspaceSize=16M
 */
public class MetaspaceOOMTest {
    public interface Facade {
        void m(String input);
    }

    public static class FacadeImpl implements Facade {
        @Override
        public void m(String input) {

        }
    }

    public static class MetaspaceFacadeInvocationHandler implements InvocationHandler {
        private Object impl;

        public MetaspaceFacadeInvocationHandler(Object impl) {
            this.impl = impl;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(impl, args);
        }
    }

    private static Map<String, Facade> classLeakingMap = new HashMap<>();

    private static void oom(HttpExchange exchange) {
        try {
            String response = "oom begin";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; ; i++) {
                String jar = "file:" + i + ".jar";
                URL[] urls = new URL[]{new URL(jar)};

                URLClassLoader newClassLoader = new URLClassLoader(urls);
                Facade t = (Facade) Proxy.newProxyInstance(newClassLoader,
                        new Class<?>[]{Facade.class},
                        new MetaspaceFacadeInvocationHandler(new FacadeImpl()));
                classLeakingMap.put(jar, t);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void srv() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8002), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(MetaspaceOOMTest::oom);
        server.start();
    }

    public static void main(String[] args) throws IOException {
        srv();
    }

}
