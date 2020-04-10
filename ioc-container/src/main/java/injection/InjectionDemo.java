package injection;

import injection.repository.UserRepository;
import model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class InjectionDemo {
    public static void main(String[] args) {
        BeanFactory applicationContextCreate = new ClassPathXmlApplicationContext("classpath:/bean-injection.xml");

        UserRepository userRepository = (UserRepository) applicationContextCreate.getBean("userRepository");
        System.out.println(userRepository.getUserList().toString());

        BeanFactory beanFactoryInjection = userRepository.getBeanFactory();
        ObjectFactory<ApplicationContext> objectFactory1 = userRepository.getApplicationContextObjectFactory();
        ApplicationContext applicationContextInjection = objectFactory1.getObject();

        System.out.println("注入的beanFactory：" + beanFactoryInjection.toString() + ";hashCode=" + beanFactoryInjection.hashCode());
        System.out.println("新建的ApplicationContext：" + applicationContextCreate.toString() + ";hashCode=" + applicationContextCreate.hashCode());
        System.out.println("注入的ApplicationContext：" + applicationContextInjection.toString() + ";hashCode=" + applicationContextInjection.hashCode());

        ObjectFactory<User> objectFactory = userRepository.getUserObjectFactory();
        User user = objectFactory.getObject();
        System.out.println("延迟注入："+user);

        Environment environment = applicationContextCreate.getBean(Environment.class);
        System.out.println("内建bean："+environment);
    }
}
