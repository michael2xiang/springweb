package com.imooc.web1.dao;

import com.imooc.web1.entity.Coffee;

import java.util.List;

public interface CoffeeDao {
    List<Coffee> getAll();

    int update(Coffee coffee);

    Coffee getById(int id);
}
