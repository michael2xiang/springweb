package injection;

import IocContain.ApplicationContextWithAnnotationAsIoc;
import model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

public class InjectionAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(InjectionAnnotationDemo.class);
        annotationConfigApplicationContext.refresh();
        lookupBean(annotationConfigApplicationContext);
    }

    @Bean
    public User user()
    {
        User user = new User();
        user.setId(22L);
        user.setName("通过注解定义的bean");
        return  user;
    }

    @Bean
    public User user2()
    {
        User user = new User();
        user.setId(33L);
        user.setName("通过注解定义的bean3");
        return  user;
    }




    private static void lookupBean(BeanFactory beanFactory)
    {
        //通过类型实时查找集合
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型实时查找集合:" + map.toString());
        }
    }
}
