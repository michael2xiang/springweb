package com.imooc.chainofresponsibility.linkedlist;

public class Demo {
    public static void main(String[] args) {
        HandlerChainWithLinkedList chain = new HandlerChainWithLinkedList();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();

    }
}
