package com.wf.utils;


import com.wf.myenum.BaseErrorEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Data
public class ResultJson<T> {
    private int code = BaseErrorEnum.SUCCESS.getErrorCode();
    private T data;
    private String message = BaseErrorEnum.SUCCESS.getErrorMsg();
    private boolean status = true;
    private Map<String, Object> otherMap = new HashMap<>();


    public ResultJson() {
        super();
    }

    public ResultJson(T t) {
        this();
        this.data = t;
    }

    public ResultJson(String message) {
        this.message = message;
    }

    public ResultJson(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public static <T> T getData(ResultJson<T> resultJson) {
        return getData(resultJson, null, null);
    }

    public static Boolean getDataAsBoolean(ResultJson<Boolean> resultJson) {
        return getData(resultJson, false, null);
    }



    public static <T> T getDataAndException(ResultJson<T> resultJson) {
        if (null != resultJson) {
            if (resultJson.isStatus()) {
                return resultJson.getData();
            } else {
                // 抛出接口返回的异常信息
                throw new BaseException(resultJson.getCode(), resultJson.getMessage());
            }
        }
        return null;
    }

    public static <T> T getData(ResultJson<T> resultJson, T defaultValue) {
        return getData(resultJson, defaultValue, null);
    }

    public static <T> T getData(ResultJson<T> resultJson, T defaultValue, Consumer<ResultJson<T>> action) {
        if (null != resultJson) {
            if (resultJson.isStatus()) {
                return resultJson.getData();
            } else if (null != action) {
                action.accept(resultJson);
            }
        }
        return defaultValue;
    }


    @Override
    public String toString() {
        return "ResultJson{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", otherMap=" + otherMap +
                '}';
    }
}
