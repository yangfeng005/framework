package com.jp.framework.common.model;

import com.jp.framework.common.util.Constant;
import com.jp.framework.common.exception.BaseException;

public class ServiceResultHelper {
    public ServiceResultHelper() {
    }

    public static <T> ServiceResult<T> genResult(boolean succeed, int retCode, String msg, T obj) {
        ServiceResult ret = new ServiceResult();
        ret.setData(obj);
        ret.setMsg(msg);
        ret.setCode(retCode);
        ret.setSucceed(succeed);
        return ret;
    }

    public static <T> boolean isSuccess(ServiceResult<T> result) {
        return result != null && result.isSucceed() && result.getCode() == 0;
    }

    public static <T> T getData(ServiceResult<T> result) {
        if(result == null) {
            throw new BaseException(500, "Network is error");
        } else if(result.getCode() != 0) {
            throw new BaseException(500, String.format("invoke hessian error! status:%s; msg:%s", new Object[]{Integer.valueOf(result.getCode()), result.getMsg()}));
        } else {
            return result.getData();
        }
    }

    public static <T> ServiceResult<T> genResultWithSuccess(T obj) {
        return genResult(true, Constant.SUCCESS, "成功", obj);
    }

    public static <T> ServiceResult<T> genResultWithSuccess() {
        return genResult(true, Constant.SUCCESS, "成功", null);
    }

    public static <T> ServiceResult<T> genResultWithFaild() {
        return genResult(false, Constant.FAILED, "失败", null);
    }

    public static <T> ServiceResult<T> genResultWithFaild(String msg,Integer code) {
        return genResult(false, code, msg, null);
    }
    public static <T> ServiceResult<T> genResultWithDataNull() {
        return genResult(false, Constant.SUCCESS, "数据为空", null);
    }

    public static <T> ServiceResult<T> toResult(BaseException baseException) {
        return toResult(baseException, null);
    }

    public static <T> ServiceResult<T> toResult(BaseException baseException, T data) {
        ServiceResult result = new ServiceResult();
        if(baseException != null) {
            result.setCode(baseException.getStatus());
            result.setMsg(baseException.getMsg());
            result.setSucceed(false);
        }

        result.setData(data);
        return result;
    }
}

