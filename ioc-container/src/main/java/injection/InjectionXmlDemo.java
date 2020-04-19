package injection;

import injection.servcie.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml 定义bean
 */
public class InjectionXmlDemo {
    public static void main(String[] args) {
        BeanFactory applicationContextCreate = new ClassPathXmlApplicationContext("classpath:/bean-injection.xml");

        UserService userService = (UserService) applicationContextCreate.getBean("userService");
        System.out.println(userService.getUser().toString());


    }
}
