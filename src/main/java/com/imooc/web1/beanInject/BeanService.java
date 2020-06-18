package com.imooc.web1.beanInject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Named("beanService")
public class BeanService {
    public BeanService() {
    }


    private BeanDao beanDao;

    @Autowired
    public BeanService(BeanDao beanDao) {
        this.beanDao = beanDao;
    }

    public void say() {
        beanDao.say();
    }
}
