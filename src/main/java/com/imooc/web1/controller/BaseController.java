package com.imooc.web1.controller;

import com.imooc.web1.error.BusinessException;
import com.imooc.web1.error.EnumBusinessError;
import com.imooc.web1.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object HandlerExecption(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errorCode", businessException.getErrCode());
            responseData.put("errorMsg", businessException.getErrMsg());

        } else {

            responseData.put("errorCode", EnumBusinessError.UNKNOW_ERROR.getErrCode());
            responseData.put("errorMsg", EnumBusinessError.UNKNOW_ERROR.getErrMsg());
        }
        return CommonReturnType.create(responseData, "fail");
    }
}
