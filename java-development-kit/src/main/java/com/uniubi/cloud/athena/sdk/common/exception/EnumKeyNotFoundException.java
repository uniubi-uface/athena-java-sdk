package com.uniubi.cloud.athena.sdk.common.exception;

import java.text.MessageFormat;

/**
 * 枚举值找不到异常
 * <p>
 * description default
 *
 * @author 阿秋@niancheng
 * @since 2019/12/9
 */
public class EnumKeyNotFoundException extends RuntimeException {

    public EnumKeyNotFoundException(Class<?> enumType, String key) {
        super(MessageFormat.format("找不到枚举类型 {0} 的key值：{1}", enumType.getName(), key));
    }

}