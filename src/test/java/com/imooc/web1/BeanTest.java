package com.imooc.web1;

import com.imooc.web1.beanInject.BeanService;
import com.imooc.web1.beanInject.StringStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanTest extends UnitTestBase {

    public BeanTest() {
        super("classpath:spring-bean.xml");
    }

    @Test
    public void getBean() {
        BeanService beanService = super.getBean("beanService");
//        BeanService beanService =  super.getBean(BeanService.class);
        beanService.say();
    }


    @Test
    public void getStore() {
        StringStore store = super.getBean("stringStore");
//        BeanService beanService =  super.getBean(BeanService.class);
        store.say();
    }
}
