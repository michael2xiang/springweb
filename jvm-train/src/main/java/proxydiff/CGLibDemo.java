package proxydiff;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * gclib  实现代理功能，给类添加新功能，而不改动原类的源码
 */
public class CGLibDemo {
    static class Car{
        public void runing()
        {
            System.out.println("-----run");
        }

        public void call()
        {
            System.out.println("-----call");
        }
    }

    static class CGLibProxy implements MethodInterceptor{

        private Object target;

        public Object getInstrance(Object target)
        {
            this.target= target;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("+++++++add method in proxy");
            Object result =  methodProxy.invokeSuper(o,objects);
            return result;
        }

        public static void main(String[] args) {
            CGLibProxy proxy=new CGLibProxy();
            Car car  = (Car) proxy.getInstrance(new Car());
            car.runing();

            car.call();

            car.runing();
        }
    }
}
