package com.wf.core;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = BaseHandlerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, BaseHandlerException e) {
        System.out.println("拦截成功" + e.getMessage());
        return ResultBody.error(e.errorCode, e.errorMsg);
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
        return ResultBody.error(BaseEnumException.INTERNAL_SERVER_ERROR);
    }


}
