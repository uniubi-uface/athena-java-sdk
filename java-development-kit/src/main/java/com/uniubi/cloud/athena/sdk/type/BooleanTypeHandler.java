package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.BooleanTypeHandler
 *
 * @author jingmu
 * @since 2020/3/20
 */
public class BooleanTypeHandler implements TypeHandler<Boolean> {

    @Override
    public Boolean get(String str) {
        return Boolean.parseBoolean(str);
    }

}
