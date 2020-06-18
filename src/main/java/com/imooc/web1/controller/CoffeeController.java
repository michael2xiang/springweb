package com.imooc.web1.controller;

import com.imooc.web1.dao.CoffeeDao;
import com.imooc.web1.entity.Coffee;
import com.imooc.web1.response.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/coffee")
public class CoffeeController extends BaseController {
    @Autowired
    private CoffeeDao coffeeDao;

    @GetMapping(value = "/getall")
    public CommonReturnType getAll() {
        List<Coffee> coffeeList = coffeeDao.getAll();
        return CommonReturnType.create(coffeeList);
    }
}
