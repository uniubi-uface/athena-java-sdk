package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.DoubleTypeHandler
 *
 * @author jingmu
 * @since 2020/3/20
 */
public class DoubleTypeHandler implements TypeHandler<Double> {

    @Override
    public Double get(String str) {
        return Double.parseDouble(str);
    }

}
