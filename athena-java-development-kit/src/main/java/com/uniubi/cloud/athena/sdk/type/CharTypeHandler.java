package com.uniubi.cloud.athena.sdk.type;

/**
 * com.uniubi.cloud.funx.type.CharTypeHandler
 *
 * @author jingmu
 * @since 2020/3/20
 */
public class CharTypeHandler implements TypeHandler<Character> {

    @Override
    public Character get(String str) {
        return str.charAt(0);
    }

}
