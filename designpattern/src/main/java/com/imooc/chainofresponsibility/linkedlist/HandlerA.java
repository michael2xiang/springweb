package com.imooc.chainofresponsibility.linkedlist;

public class HandlerA extends AbstractHandler {
    @Override
    public boolean doHandle() {
        System.out.println("---HandlerA");
        return true;
    }
}
