package lookup;

import lookup.annotation.MyAnnotation;
import model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class LookUpDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/bean.xml");

        //通过bean name实时查找
        User userByRealTime = (User) beanFactory.getBean("user");
        System.out.println("通过bean name实时查找:" + userByRealTime.toString() + ";hashCode:" + userByRealTime.hashCode());

        //通过bean name延迟查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User userByLazy = objectFactory.getObject();
        System.out.println("通过bean name延迟查找:" + userByLazy.toString() + ";hashCode:" + userByLazy.hashCode());

        //通过类型实时查找
        User userByType = beanFactory.getBean(User.class);
        System.out.println("通过类型实时查找:" + userByType.toString() + ";hashCode:" + userByRealTime.hashCode());

        //通过类型实时查找集合
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            ObjectProvider a = listableBeanFactory.getBeanProvider(User.class);

            Map<String, User> map = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("通过类型实时查找集合:" + map.toString());
        }

        //通过注解实时查找集合
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> map = (Map) listableBeanFactory.getBeansWithAnnotation(MyAnnotation.class);
            System.out.println("通过注解实时查找集合:" + map.toString());
        }


    }
}
