package proxydiff;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class cachediff {
    public static void main(String[] args) throws ExecutionException {
        Cache<String,String> cache = CacheBuilder.newBuilder().maximumSize(10).build();
        cache.put("key1","--------value1");
        String value = cache.get("key1", new Callable<String>(){
            @Override
            public String call() throws Exception {
                return "";
            }
        });
        System.out.println(value);

    }
}
