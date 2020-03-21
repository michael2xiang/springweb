package com.imooc.web1.beanInject;

import javax.inject.Named;

@Named("stringStore")
public class StringStore implements Store<String> {

    @Override
    public void say() {
        System.out.println("StringStore  say ");
    }
}
