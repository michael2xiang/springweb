package com.imooc.chainofresponsibility.linkedlist;

public class HandlerB extends AbstractHandler {
    @Override
    public boolean doHandle() {
        System.out.println("---HandlerB");
        return true;

    }
}
