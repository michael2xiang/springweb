package com.imooc.web1.beanInject;

public class IntergeStore implements Store<Integer> {
    @Override
    public void say() {
        System.out.println("IntergeStore say");
    }
}
