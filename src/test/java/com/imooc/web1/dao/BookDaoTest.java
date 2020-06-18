package com.imooc.web1.dao;

import com.imooc.web1.entity.Book;
import com.imooc.web1.entity.TaskInstanceExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private TaskInstanceMapper taskInstanceMapper;

    @Test
    public void GetBook() {
        List<Book> books = bookDao.getAllBook();
        int size = books.size();
        assertEquals(6, size);
    }

    @Test
    public void UpdateBook() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("test");
//        book.setPrice(100.0);
        bookDao.updateBook(book);

        Book after = bookDao.getBook(1);

//        boolean a = after.getPrice() == 100;
//        assertEquals(a,true);
        assertEquals(after.getTitle(), "test");


    }

    @Test
    public void GetTask() {
        TaskInstanceExample taskInstanceExample = new TaskInstanceExample();
        TaskInstanceExample.Criteria criteria = taskInstanceExample.createCriteria();
        criteria.andEndDateIsNotNull().andDagIdIsNotNull();
        taskInstanceExample.setOrderByClause("task_id desc");
        long count = taskInstanceMapper.countByExample(taskInstanceExample);
        assertTrue(count > 0);

    }

}