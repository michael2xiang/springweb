package com.imooc.EventBus;

public class Demo {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        AObserver a = new AObserver();
        BObserver b = new BObserver();
        CObserver c = new CObserver();
        eventBus.register(a);
        eventBus.register(b);
        eventBus.register(c);
        Long id = 1L;
        System.out.println("in demo");

        eventBus.post(id);
    }

    public static class AObserver {
        @Subscribe
        public void Handler(Long id) {
            System.out.println("in A--Observer.Handler id=" + id.toString());
        }
    }
    public static class BObserver {
        @Subscribe
        public void Handler(Long id) {
            System.out.println("in B--Observer.Handler id=" + id.toString());
        }
    }
    public static class CObserver {
        @Subscribe
        public void Handler(Long id) {
            System.out.println("in C--Observer.Handler id=" + id.toString());
        }
    }

}
