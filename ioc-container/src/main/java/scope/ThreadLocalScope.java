package scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalScope implements Scope {
    public static final String name = "thread-local";

    private final NamedThreadLocal<Map<String, Object>> threadLocal = new NamedThreadLocal<Map<String, Object>>(name) {
        @Override
        public Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };


    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> context = getCurrent();
        Object value = context.get(name);
        if (value == null) {
            value = (Object) objectFactory.getObject();
            context.put(name, value);
        }
        return value;
    }

    private Map<String, Object> getCurrent() {
        return threadLocal.get();
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> context = getCurrent();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String, Object> context = getCurrent();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        return String.valueOf(Thread.currentThread().getId());
    }
}
