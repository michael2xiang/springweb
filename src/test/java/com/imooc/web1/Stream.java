//package com.imooc.web1;
//
//import lombok.extern.slf4j.Slf4j;
//import lombok.var;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//import java.util.stream.Collectors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class Stream {
//    //参考资料
//    //https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html
//    //https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
//    @Test
//    public void map() {
//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
//        log.info("squaresList " + squaresList);
//    }
//
//    @Test
//    public void foreach() {
//        Random random = new Random();
//        var top10 = random.ints().limit(10);
//        top10.forEach(System.out::println);
//        top10.forEach(t -> log.info(String.valueOf(t)));
//    }
//
//    @Test
//    public void parallel() {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        var count = strings.parallelStream().filter(q -> q.isEmpty()).count();
//        log.info("parallel count:" + count);
//    }
//
//    @Test
//    public void collectors() {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
//        List<String> strList = strings.stream().filter(q -> !q.isEmpty()).collect(Collectors.toList());
//        log.info("strList:" + strList);
//    }
//
//    @Test
//    public void stringIsEmpty() {
//        String a = null;
////空字符串是，a.isEmpty() 报异常，所以字符串判空，使用StringUtils.isEmpty
////        boolean flat = a.isEmpty();
//        boolean flat = StringUtils.isEmpty(a);
//        System.out.println("flat：" + flat);
//    }
//}
