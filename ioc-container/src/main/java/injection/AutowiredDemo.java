package injection;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *调试@Autowired的实现源码
 */
public class AutowiredDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AutowiredDemo.class);
        annotationConfigApplicationContext.refresh();

        AutowiredDemo autowiredDemo = annotationConfigApplicationContext.getBean(AutowiredDemo.class);

        System.out.println("实时注入，调试@Autowired实现源码:" + autowiredDemo.user);
        annotationConfigApplicationContext.close();


    }

    @Autowired
    private User user;

    @Bean
    public User user()
    {
        User user = new User();
        user.setId(11L);
        user.setName("通过注解定义的bean11111");
        return  user;
    }
}
