package com.imooc.chainofresponsibility.arraylist;

public class AHandler implements IHandler {
    @Override
    public boolean handle() {
        System.out.println("---HandlerA");
        return true;
    }
}
