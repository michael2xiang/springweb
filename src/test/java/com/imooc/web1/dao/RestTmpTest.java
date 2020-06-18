package com.imooc.web1.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTmpTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void Get() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://baidu.com/s?wd={k}")
                .build("a");
        String re = restTemplate.getForObject(uri, String.class);
    }
}
