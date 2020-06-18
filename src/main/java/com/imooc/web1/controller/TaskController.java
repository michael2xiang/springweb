package com.imooc.web1.controller;

import com.imooc.web1.dao.TaskInstanceMapper;
import com.imooc.web1.entity.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController(value = "/task")
@RestController
public class TaskController {

    @Autowired
    private TaskInstanceMapper taskInstanceMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<TaskInstance> GetTaskList(@RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size) {
        return taskInstanceMapper.findAllWithParams(page, size);

    }
}
