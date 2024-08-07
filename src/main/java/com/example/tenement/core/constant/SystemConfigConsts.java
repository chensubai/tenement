package com.example.tenement.core.constant;

/**
 * 系统配置相关常量
 */
public class SystemConfigConsts {

    private SystemConfigConsts() {
        throw new IllegalStateException(CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * Http 请求认证 Header
     */
    public static final String HTTP_AUTH_HEADER_NAME = "Authorization";

    /**
     * 前台门户系统标识
     */
    public static final String NOVEL_FRONT_KEY = "front";
    /**
     * 后台门户系统标识
     */
    public static final String NOVEL_ADMIN_KEY = "admin";
    /**
     * 常量类实例化异常信息
     */
    public static final String CONST_INSTANCE_EXCEPTION_MSG = "Constant class";

}
