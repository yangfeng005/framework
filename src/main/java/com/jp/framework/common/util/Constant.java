package com.jp.framework.common.util;

public final class Constant {

    public static int SUCCESS = 200;
    public static int FAILED = 404;
    public static Integer INVALID_FLG = 0; // 数据无效
    public static Integer VALID_FLG = 1;// 数据有效/解禁
    public static Integer DISABLE = 2;//禁用
    public static Integer IS_LEAF = 1;//叶子结点
    public static String USER_CS_PWD = "123456";//用户初始密码
    public static String SUPER_ADMIN_ROLE = "超级管理员";
    /**
     * 审核状态
     */
    public static Integer REVIEW_STATUS_RELEASE = 1;//发布
    public static Integer REVIEW_STATUS_EDITING = 2;//编辑中
    public static Integer REVIEW_STATUS_REVIEWING = 3;//审核中
    public static Integer REVIEW_STATUS_NOT_PASS = 4;//驳回

    /**
     * 投票状态
     */
    public static Integer VOTE_STATUS_DEFAULT = 0; // 暂未开启
    public static Integer VOTE_STATUS_START = 1; // 已开启
    public static Integer VOTE_STATUS_END = 2; // 已结束

    public static String PARENT_FLG = "0"; // 父节点
    public static Integer IS_CUSTOM = 1;//自定义标识
    public static Integer IS_DEFAULT = 0;//默认标识

    /**
     * 商品品类查询类型
     */
    public static Integer QUERY_CLASSIFY = 1; // 查询商品品类
    public static Integer QUERY_STANDARD = 2; // 查询商品规格

    /**
     * 品类规格设定状态
     */
    public static Integer IS_SETUP = 1; // 已设定
    public static Integer IS_NOT_SETUP = 2; // 未设定

    /**
     * 商品补录状态
     */
    public static Integer IS_RECORD = 1;//已经补录
    public static Integer IS_NOT_RECORD = 2;//未补录

    /**
     * 商品安全等级计算方法 1：系统智能计算 2：手工定义
     */
    public static Integer IS_INTELLIGENCE = 1; // 系统智能计算
    public static Integer IS_HARDWORK = 2; // 手工定义

    public static Integer IS_SINGLE = 1;//自定义单组
    public static Integer IS_DOUBLE = 2;//自定义多组

    /**
     * 1文章审核，2成分审核
     */
    public static Integer AUDIT_EAASY = 1;//审核文章
    public static Integer AUDIT_INGREDIENT = 2;//审核成分

    /**
     * 登录短信验证码
     */
    public static final String SMS_LOGIN_IDENTIFY_CODE = "_smsLogin";

    /**
     * 短信发送结果状态
     */
    public static final String SMS_SEND_STATUS_OK = "OK";//成功
    public static final String SMS_SEND_STATUS_ERROR = "ERROR";//失败

    /**
     * SessionKey当前登录用户
     */
    public static final String SESSION_CURRENT_USER = "currentUser";

    /**
     * 模块配置搜索智能推荐开关
     */
    public static final Integer SWITCH_OPEN = 1; // 开
    public static final Integer SWITCH_DOWN = 0; // 关

    public static class ErrorCode {

        /**
         * 无效参数
         */
        public static Integer INVALID_PARAM_CODE = -101;
        public static String INVALID_PARAM_MSG = "无效参数";

        /**
         * 没有权限
         */
        public static Integer PERMISSION_DENIED_CODE = -102;
        public static String PERMISSION_DENIED_MSG = "没有权限";

        /**
         * 通用错误
         */
        public static Integer COMMON_ERROR_CODE = -103;
        public static String COMMON_ERROR_MSG = "服务器繁忙，请稍后再试";

        /**
         * 登录失效
         */
        public static Integer INVALID_LOGIN_CODE = -104;
        public static String INVALID_LOGIN_MSG = "登录失效";

        /**
         * 数据库操作失败
         */
        public static Integer DATABASE_OPERATION_ERROR_CODE = -105;
        public static String DATABASE_OPERATION_ERROR_MSG = "数据库操作失败";

        /**
         * token失效
         */
        public static Integer INVALID_TOKEN_CODE = -106;
        public static String INVALID_TOKEN_MSG = "用户未登录或登录信息已失效";

        /**
         * 服务器异常
         */
        public static Integer SERVER_ERROR_CODE = -200;
        public static String SERVER_ERROR_MSG = "服务器异常";

        /**
         * 用户名不存在
         */
        public static Integer USER_NOT_EXIST_ERROR = -107;
        public static String USER_NOT_EXIST_ERROR_MSG = "用户不存在";

        /**
         * 用户名或密码错误
         */
        public static Integer PASSWORD_ERROR = -107;
        public static String PASSWORD_ERROR_MSG = "密码错误";

        /**
         * 账号被禁用
         */
        public static Integer USER_DISABLE_ERROR = -108;
        public static String USER_DISABLE_ERROR_MSG = "账号已被禁用，请联系管理员";

        /**
         * 用户已存在
         */
        public static Integer USER_AlREADY_EXIST_ERROR = -109;
        public static String USER_AlREADY_EXIST_ERROR_MSG = "用户已存在";

        /**
         * 角色已存在
         */
        public static Integer ROLE_AlREADY_EXIST_ERROR = -110;
        public static String ROLE_AlREADY_EXIST_ERROR_MSG = "角色已存在";

        /**
         * 品类已存在
         */
        public static Integer CLASSIFY_AlREADY_EXIST_ERROR = -111;
        public static String CLASSIFY_AlREADY_EXIST_ERROR_MSG = "品类已存在";

        /**
         * 产品分类已存在
         */
        public static Integer PRODUCT_CATEGORY_AlREADY_EXIST_ERROR = -112;
        public static String PRODUCT_CATEGORY_AlREADY_EXIST_ERROR_MSG = "产品分类已存在";

        /**
         * 文件上传失败
         */
        public static Integer FILE_UPLOAD_ERROR = -113;
        public static String FILE_UPLOAD_ERROR_MSG = "文件上传失败";

        /**
         * 文件不存在
         */
        public static Integer FILE_NOT_EXIST_ERROR = -114;
        public static String FILE_NOT_EXIST_ERROR_MSG = "文件不存在";

        /**
         * 文章分类已存在
         */
        public static Integer ESSAY_CLASSIFY_AlREADY_EXIST_ERROR = -115;
        public static String ESSAY_CLASSIFY_AlREADY_EXIST_ERROR_MSG = "文章分类已存在";

        /**
         * 标签已存在
         */
        public static Integer TAG_AlREADY_EXIST_ERROR = -116;
        public static String TAG_AlREADY_EXIST_ERROR_MSG = "标签已存在";

        /**
         * 成分已存在
         */
        public static Integer INGREDIENT_AlREADY_EXIST_ERROR = -117;
        public static String INGREDIENT_AlREADY_EXIST_ERROR_MSG = "成分已存在";

        /**
         * 成分分类已存在
         */
        public static Integer INGREDIENT_CLASSIFY_AlREADY_EXIST_ERROR = -118;
        public static String INGREDIENT_CLASSIFY_AlREADY_EXIST_ERROR_MSG = "成分分类已存在";

        /**
         * 指标名称已存在
         */
        public static Integer CLASSIFY_INDICATOR_NAME_AlREADY_EXIST_ERROR = -119;
        public static String CLASSIFY_INDICATOR_NAME_AlREADY_EXIST_ERROR_MSG = "指标名称已存在";

        /**
         * 模块发布错误
         */
        public static Integer MODULE_RELEASE_ERROR = -120;
        public static String MODULE_RELEASE_ERROR_MSG = "模块列表为空或者版本记录内容为空";
    }
}

