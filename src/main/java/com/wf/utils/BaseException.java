package com.wf.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

public class BaseException extends RuntimeException {

    private String formatMsg;

    private int errorCode;

    private Object[] params;

    public BaseException(String message) {
            super(message);
            this.formatMsg=message;
    }

    public BaseException(String message,Object... params) {
        super(message);
        this.formatMsg=message;
        this.params=params;
    }

    public BaseException(int errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
    }

    //基础业务异常拦截
    @Override
    public String getMessage() {
        return StringUtils.format(formatMsg, params);
    }

    @Override
    public String toString() {
        return StringUtils.format(formatMsg, params);
    }

}
