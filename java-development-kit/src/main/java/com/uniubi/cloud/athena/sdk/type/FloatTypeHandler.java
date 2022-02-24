package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.FloatTypeHandler
 *
 * @author jingmu
 * @date 2020/3/20
 */
public class FloatTypeHandler implements TypeHandler<Float> {

    @Override
    public Float get(String str) {
        return Float.parseFloat(str);
    }

}
