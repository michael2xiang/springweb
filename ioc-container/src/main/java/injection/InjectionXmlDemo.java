package injection;

import injection.repository.UserRepository;
import injection.servcie.UserService;
import model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class InjectionXmlDemo {
    public static void main(String[] args) {
        BeanFactory applicationContextCreate = new ClassPathXmlApplicationContext("classpath:/bean-injection.xml");

        UserService userService = (UserService) applicationContextCreate.getBean("userService");
        System.out.println(userService.getUser().toString());


    }
}
