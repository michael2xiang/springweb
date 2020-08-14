package com.imooc.chainofresponsibility.linkedlist;

public abstract class AbstractHandler {
    protected AbstractHandler nextAbstractHandler = null;

    public void setNextAbstractHandler(AbstractHandler nextAbstractHandler) {
        this.nextAbstractHandler = nextAbstractHandler;
    }

    public final void handle() {
        boolean isHandled = doHandle();
        if (!isHandled && nextAbstractHandler != null) {
            nextAbstractHandler.doHandle();
        }
    }

    protected abstract boolean doHandle();
}

