package com.uniubi.cloud.athena.sdk.common.utils;

import com.uniubi.cloud.athena.sdk.common.enums.CommonEnum;
import com.uniubi.cloud.athena.sdk.common.exception.EnumKeyAlreadyExistException;
import com.uniubi.cloud.athena.sdk.common.exception.EnumKeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举初始化工具
 * @author Niancheng
 * @since 2019/6/29
 */
public class UniUbiEnumUtils {

    private static final Map<Class<? extends CommonEnum>, Map> ENUM_MAP;

    static {
        ENUM_MAP = new HashMap<>();
    }

    public static synchronized <K> void initEnum(Class<? extends CommonEnum<K>> commonEnumClass) {
        @SuppressWarnings("unchecked")
        Map<Object, CommonEnum> objectCommonEnumMap = ENUM_MAP.get(commonEnumClass);

        if (objectCommonEnumMap != null) {
            return;
        }
        CommonEnum<K>[] enumConstants = commonEnumClass.getEnumConstants();
        Map<K, CommonEnum<K>> commonEnumMap = new HashMap<>(enumConstants.length);
        for (CommonEnum<K> enumConstant : enumConstants) {
            K enumCode = enumConstant.getEnumCode();
            if (commonEnumMap.containsKey(enumCode)) {
                throw new EnumKeyAlreadyExistException(commonEnumClass, String.valueOf(enumCode));
            }
            commonEnumMap.put(enumConstant.getEnumCode(), enumConstant);
        }
        ENUM_MAP.put(commonEnumClass, commonEnumMap);
    }

    public static <E extends CommonEnum<K>, K> E getByEnumCode(Class<E> commonEnumClass, K code) {
        @SuppressWarnings("unchecked")
        Map<K, E> commonEnumMap = ENUM_MAP.get(commonEnumClass);
        if (commonEnumMap == null) {
            return null;
        }
        return commonEnumMap.get(code);
    }

    public static <E extends CommonEnum<K>, K> E getByEnumCodeAndThrow(Class<E> commonEnumClass, K code) {
        E byEnumCode = getByEnumCode(commonEnumClass, code);
        if (byEnumCode == null) {
            throw new EnumKeyNotFoundException(commonEnumClass, String.valueOf(code));
        }
        return byEnumCode;
    }

}