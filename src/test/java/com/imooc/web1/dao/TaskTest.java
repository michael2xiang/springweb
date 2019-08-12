package com.imooc.web1.dao;

import com.imooc.web1.entity.TaskInstance;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {
    @Autowired
    private TaskInstanceMapper taskInstanceMapper;

    @Test
    public void GetListByRowBound()
    {
        //偏移量
        List<TaskInstance> taskInstanceList = taskInstanceMapper
                .findAllWithRowBounds(new RowBounds(11,10));
        Assert.assertTrue(taskInstanceList.size()==10);

//        taskInstanceMapper.findAllWithRowBounds(new RowBounds(1,10))
//                .forEach(q=>log.info
//        );

    }

    @Test
    public void GetListByParam()
    {
        //页数
        List<TaskInstance> taskInstanceList =  taskInstanceMapper.
                findAllWithParams(2,10);
        Assert.assertTrue(taskInstanceList.size()==10);
        Logger  log = Logger.getLogger("test");

    }

}
