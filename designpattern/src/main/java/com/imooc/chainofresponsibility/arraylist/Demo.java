package com.imooc.chainofresponsibility.arraylist;

public class Demo {
    public static void main(String[] args) {
        HandleChainWithArrayList chain = new HandleChainWithArrayList();
        chain.addHandler(new AHandler());    chain.addHandler(new BHanlder());
        chain.handle();
    }
}
