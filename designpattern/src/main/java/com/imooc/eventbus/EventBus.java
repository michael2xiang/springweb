package com.imooc.eventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

public class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();
    public EventBus(){
        this(MoreExecutors.directExecutor());
    }
    protected EventBus (Executor executor){
        this.executor = executor;
    }
    public void register(Object object){
        registry.register(object);
    }
    public void post(final Object event){
        List<ObserverAction> matchedObserverActions = registry.getMatchedObserverActions(event);
        for (final ObserverAction action:  matchedObserverActions)
        {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    action.execute(event);
                }
            });
        }
    };
}
