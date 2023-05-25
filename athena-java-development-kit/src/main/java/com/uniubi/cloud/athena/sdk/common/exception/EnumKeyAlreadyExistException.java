package com.uniubi.cloud.athena.sdk.common.exception;

import java.text.MessageFormat;

/**
 * 枚举类型key值重复异常
 * <p>
 * description: default
 * @author 阿秋@niancheng
 * @since 2019/12/9
 */
public class EnumKeyAlreadyExistException extends RuntimeException {

    public EnumKeyAlreadyExistException(Class<?> enumType, String key) {
        super(MessageFormat.format("枚举类型 {0} key值重复，重复key为：{1}", enumType.getName(), key));
    }

}