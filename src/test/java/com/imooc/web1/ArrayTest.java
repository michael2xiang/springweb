package com.imooc.web1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArrayTest {
    @Test
    public  void ArrayMoveIf()
    {
        ArrayList<String> arra = new ArrayList<String>();
        arra.add("a");
        arra.add("b");
        arra.add(null);
        arra.removeIf(e->e==null);
        System.out.println(arra.toString());

    }
}
