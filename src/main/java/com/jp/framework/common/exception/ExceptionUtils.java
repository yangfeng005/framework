package com.jp.framework.common.exception;

import com.jp.framework.common.exception.BaseException;
import com.jp.framework.common.model.ServiceResult;

public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static BaseException genWithResult(ServiceResult<?> result) {
        return result != null?new BaseException(result.getCode(), result.getMsg()):new BaseException(-1, "invoke hessian error");
    }
}
