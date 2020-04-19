package injection;

import model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.Map;
import java.util.Set;

/**
 * 依赖注入，多个同类型bean限定加载，延迟注入，不存在是否报错
 */
public class InjectionAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(InjectionAnnotationDemo.class);
        annotationConfigApplicationContext.refresh();

        InjectionAnnotationDemo injectionAnnotationDemo = (InjectionAnnotationDemo) annotationConfigApplicationContext.getBean(InjectionAnnotationDemo.class);

        System.out.println("实时注入，调试@Autowired实现源码:" + injectionAnnotationDemo.user);

//        System.out.println("不安全的延迟bean，没|多个 bean报错:" + injectionAnnotationDemo.users.getObject());
//        System.out.println("不安全的延迟 lazy beanUser，没bean不会报错，多个报错:" +injectionAnnotationDemo.lazyUser.toString());
//        System.out.println("安全的延迟bean，没bean不会报错，多个报错:" + injectionAnnotationDemo.users.getIfAvailable());
//        injectionAnnotationDemo.users.forEach(System.out::println);
//        lookupBean(annotationConfigApplicationContext);
    }

    @Autowired
    @Qualifier(value = "user") //限定 bean id
    private User user;

    @Autowired
    @Lazy
    @Qualifier(value = "user") //限定 bean id
    private User lazyUser;

    @Autowired
    @Qualifier(value = "user") //限定 bean id
    private ObjectProvider<User> users; //支持单一，集合bean

    @Autowired
    @Qualifier(value = "user") //限定 bean id
    private ObjectFactory<User> objectFactoryUser; //单一

    @Autowired
    @Qualifier(value = "user") //限定 bean id
    private ObjectFactory<Set<User>> objectFactoryUserSet;//集合


    @Bean
    @Qualifier
    public User user()
    {
        User user = new User();
        user.setId(11L);
        user.setName("通过注解定义的bean11111");
        return  user;
    }

    @Bean
    public User user2()
    {
        User user = new User();
        user.setId(22L);
        user.setName("通过注解定义的bean2222");
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
