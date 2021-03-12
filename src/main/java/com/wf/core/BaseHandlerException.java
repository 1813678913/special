package com.wf.core;

public class BaseHandlerException extends RuntimeException {

    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;


    public BaseHandlerException() {
        super();
    }

    public BaseHandlerException(BaseException errorInfoInterface) {
        super(errorInfoInterface.errorCode());
        this.errorCode = errorInfoInterface.errorCode();
        this.errorMsg = errorInfoInterface.errorMsg();
    }

    public BaseHandlerException(BaseException errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.errorCode(), cause);
        this.errorCode = errorInfoInterface.errorCode();
        this.errorMsg = errorInfoInterface.errorMsg();
    }

    public BaseHandlerException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BaseHandlerException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseHandlerException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }



}
