package com.stanley.apiutils.exception;

import com.stanley.apiutils.api.CommonErrorCode;
import com.stanley.apiutils.api.ErrorCode;

/**
 * @Description 自定义业务类异常
 * @date 2017/8/4
 * @author 13346450@qq.com 童晟
 */
public class AppBusinessException extends BaseException {

    private static final ErrorCode DEFAULT_CODE = CommonErrorCode.INTERNAL_ERROR;

    private String code = DEFAULT_CODE.getCode();

    //类似Http状态码
    private int httpStatus = DEFAULT_CODE.getStatus();

    public AppBusinessException(String code, int httpStatus, String message) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public AppBusinessException(String message) {
        super(message);
    }

    /**
     * @param errorCode 状态码, 这个字段会在错误信息里返回给客户端.
     * @param message
     */
    public AppBusinessException(ErrorCode errorCode, String message) {
        this(errorCode.getCode(), errorCode.getStatus(), message);
    }

    public AppBusinessException(ErrorCode errorCode) {
        this(errorCode, errorCode.getMessage());
    }

    public String getCode() {
        return code;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
