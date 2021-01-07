package com.wf.myenum;

import lombok.Getter;

@Getter
public enum BaseErrorEnum implements BaseError {
    SUCCESS(200, "执行成功"),
    ERROR(-1, "执行失败"),
    ERROR_MSG(1, "前端弹窗提示异常"),
    MSGN(0, "不存在的错误码"),
    NO_ACCESS(-2, "您没有权限访问此方法，或登录已失效"),
    EXCEPTION_UNKNOWN(5000, "未知名的错误"),
    COMMON_ERROR(5100, "程序执行异常"),
    ERROR_4000(4000, "请求IP不合法"),
    ERROR_4001(4001, "请求次数超限"),
    ERROR_4002(4002, "非法的请求参数"),
    ERROR_4003(4003, "非法的通知内容"),
    ERROR_4004(4004, "非法的数字签名"),
    ERROR_4005(4005, "非法的调用标识"),
    ERROR_4006(4006, "非法的通知类型"),
    ERROR_4007(4007, "非法的版本标记"),
    ERROR_4008(4008, "非法的数据格式"),
    ERROR_4009(4009, "非法的加密标识"),
    ERROR_4010(4010, "非法的消息ID"),
    ERROR_4011(4011, "请求数量超限"),
    ERROR_4012(4012, "请求连接超时"),
    ERROR_4013(4013, "系统异常，请重试"),
    ERROR_4014(4014, "返回报文为空"),
    ERROR_4015(4015, "返回结果失败"),
    ERROR_4016(4016, "非法的网关信息"),
    ERROR_4017(4017, "业务服务异常"),
    ERROR_4018(4018, "业务系统异常");


    private int errorCode;
    private String errorMsg;

    BaseErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    @Override
    public String getError() {
        return this.getErrorMsg();
    }

    @Override
    public int getCode() {
        return this.getErrorCode();
    }

    public static BaseErrorEnum getBsseErrorEnum(int code) {
        for (BaseErrorEnum baseErrorEnum : BaseErrorEnum.values()) {
            if (baseErrorEnum.getErrorCode() == code) {
                return baseErrorEnum;
            }
        }
        return BaseErrorEnum.MSGN;
    }
}
