package com.imooc.chainofresponsibility.arraylist;

public class BHanlder implements  IHandler {
    @Override
    public boolean handle() {
        System.out.println("---HandlerA");
        return true;
    }
}
