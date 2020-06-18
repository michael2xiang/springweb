package IocContain;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 基本的BeanFactory ioc
 */
public class BeanFactoryAsIoc {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        int beanCount = xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/bean.xml");
        System.out.println("bean总数量：" + beanCount);
    }
}
