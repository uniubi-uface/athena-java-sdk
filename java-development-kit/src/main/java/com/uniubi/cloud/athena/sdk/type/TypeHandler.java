package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.TypeHandler
 *
 * @author jingmu
 * @date 2020/3/20
 */
public interface TypeHandler<T> {

    T get(String str);

    default String getString(T t) {
        return String.valueOf(t);
    }

}
