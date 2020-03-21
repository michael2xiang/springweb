package com.imooc.web1.beanInject;

import org.springframework.stereotype.Repository;

@Repository
public class BeanDao {


    public void say()
    {
        System.out.println(" BeanService say");
    }
}
