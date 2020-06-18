package bean;

import model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 3).addPropertyValue("name", "BeanDefinitionCreateDemo");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.add("id", 4).add("name", "BeanDefinitionCreateDemo44");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);


    }
}
