package com.imooc.chainofresponsibility.linkedlist;

public class HandlerChainWithLinkedList {
    private AbstractHandler head = null;
    private AbstractHandler tail = null;

    public void addHandler(AbstractHandler handler) {
        handler.setNextAbstractHandler(handler);
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        tail.setNextAbstractHandler(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }

}
