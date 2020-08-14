package com.imooc.chainofresponsibility.arraylist;

import java.util.ArrayList;
import java.util.List;

public class HandleChainWithArrayList {
    private List<IHandler> chain = new ArrayList<>();

    public void addHandler(IHandler handler) {
        this.chain.add(handler);
    }

    public void handle() {
        for (IHandler handler : chain) {
            boolean isHandled = handler.handle();
            if (isHandled) {
                break;
            }

        }
    }
}
