package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.StringTypeHandler
 *
 * @author jingmu
 * @since 2020/3/20
 */
public class StringTypeHandler implements TypeHandler<String> {

    @Override
    public String get(String str) {
        return str;
    }

}
