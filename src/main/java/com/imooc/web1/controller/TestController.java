package com.imooc.web1.controller;

import com.imooc.web1.error.BusinessException;
import com.imooc.web1.error.EnumBusinessError;
import com.imooc.web1.response.BookVO;
import com.imooc.web1.response.CommonReturnType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/test")
public class TestController extends BaseController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CommonReturnType get() {
        List<BookVO> bookVOList = new ArrayList<BookVO>();
        for (int i = 0; i < 10000; i++) {
            BookVO vo = new BookVO();
            vo.setId(1);
            vo.setTitle("aaBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBbBbBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
            bookVOList.add(vo);
        }

        return CommonReturnType.create(bookVOList);
    }

    @RequestMapping(value = "/updateTitle", method = RequestMethod.GET)
    public CommonReturnType updateTitle(String title) throws Exception {

        if (title == null || "".equals(title)) {
            throw new BusinessException(EnumBusinessError.PARAM_ERROR, "title not allow null");
        } else if ("e".equals(title)) {
            throw new Exception("exception");
        }
        BookVO vo = new BookVO();
        vo.setId(1);
        vo.setTitle(title);
        return CommonReturnType.create(vo);
    }


}