package injection;

import injection.postProcessor.CustomBeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * 将外部对象加载到spring ioc容器，registerResolvableDependency
 */
public class ResolvableDependencyDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ResolvableDependencyDemo.class);
        //回调拓展方式：参数为函数接口（实现了制定接口的class实例），加到ArrayList容器中，在后面调用
        CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        annotationConfigApplicationContext.addBeanFactoryPostProcessor(customBeanFactoryPostProcessor);
//      函数接口的写法二：lambda表达式，匿名类实例
//        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
//            beanFactory.registerResolvableDependency(String.class, "新加外部依赖来源lamdal");
//        });

        annotationConfigApplicationContext.refresh();
        annotationConfigApplicationContext.close();

    }
}
