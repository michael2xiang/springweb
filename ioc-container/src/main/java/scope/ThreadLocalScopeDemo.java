package scope;

import model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义bean scope作用域
 */
public class ThreadLocalScopeDemo {

    @Bean
    @Scope(value = ThreadLocalScope.name)
    private User user() {
        User user = new User();
        user.setId(1L);
        user.setName("test");
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(ThreadLocalScopeDemo.class);
//      lambda表达式，匿名类实例
        annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerScope(ThreadLocalScope.name, new ThreadLocalScope());
        });

        annotationConfigApplicationContext.refresh();
        lookUpBean(annotationConfigApplicationContext);

        annotationConfigApplicationContext.close();
    }

    public static void lookUpBean(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(() -> {
                User user = (User) applicationContext.getBean("user");
//                System.out.println("thread id="+Thread.currentThread().getId()+",user hascode="+user.hashCode());
                //format方法
                System.out.printf("thread id=%s,user hascode=%s %n", Thread.currentThread().getId() , user.hashCode());
            });
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}
