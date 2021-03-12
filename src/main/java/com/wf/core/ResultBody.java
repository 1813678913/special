package com.wf.core;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class ResultBody<T> {

    private String code=BaseEnumException.SUCCESS.errorCode();

    private String message=BaseEnumException.SUCCESS.errorMsg();

    /**
     * 响应结果
     */
    private T result;

    public ResultBody(BaseException errorInfo) {
        this.code = errorInfo.errorCode();
        this.message = errorInfo.errorMsg();
    }

    public ResultBody() {
    }

    public ResultBody(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResultBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBody(T result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultBody success(Object data) {
        ResultBody rb = new ResultBody();
        rb.setCode(BaseEnumException.SUCCESS.errorCode());
        rb.setMessage(BaseEnumException.SUCCESS.errorMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(BaseException errorInfo) {
        ResultBody rb = new ResultBody();
        rb.setCode(errorInfo.errorCode());
        rb.setMessage(errorInfo.errorMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String code, String message) {
        ResultBody rb = new ResultBody();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBody error(String message) {
        ResultBody rb = new ResultBody();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
