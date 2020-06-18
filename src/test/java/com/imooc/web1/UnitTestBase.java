package com.imooc.web1;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UnitTestBase {
    private ClassPathXmlApplicationContext context;
    private String stringXmlPath;

    public UnitTestBase() {
    }

    ;

    public UnitTestBase(String stringXmlPath) {
        this.stringXmlPath = stringXmlPath;
    }

    ;

    @Before
    public void before() {

        if (stringXmlPath == null || stringXmlPath.equals("")) {
            stringXmlPath = "classPath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(stringXmlPath.split("[,\\s]+"));
            context.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.close();

    }


    @SuppressWarnings("unchecked")
    protected <T extends Object> T getBean(String beanId) {
        return (T) context.getBean(beanId);
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        return (T) context.getBean(clazz);
    }

}
