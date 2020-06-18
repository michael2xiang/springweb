package com.imooc.web1.dao;

import com.imooc.web1.entity.TaskInstance;
import com.imooc.web1.entity.TaskInstanceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

public interface TaskInstanceMapper {
    long countByExample(TaskInstanceExample example);

    int deleteByExample(TaskInstanceExample example);

    int insert(TaskInstance record);

    int insertSelective(TaskInstance record);

    List<TaskInstance> selectByExample(TaskInstanceExample example);

    int updateByExampleSelective(@Param("record") TaskInstance record, @Param("example") TaskInstanceExample example);

    int updateByExample(@Param("record") TaskInstance record, @Param("example") TaskInstanceExample example);

    @Select("select * from task_instance order by task_id")
    List<TaskInstance> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from task_instance order by task_id")
    List<TaskInstance> findAllWithParams(@Param("pageNum") int pageNum,
                                         @Param("pageSize") int pageSize);


}