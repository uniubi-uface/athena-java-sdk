package com.uniubi.cloud.athena.sdk.type;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * com.uniubi.cloud.funx.type.TypeHandlerRegistry
 *
 * @author jingmu
 * @date 2020/3/20
 */
public class TypeHandlerRegistry {

    private static final Map<Type, TypeHandler<?>> ALL_TYPE_HANDLERS;

    static {
        ALL_TYPE_HANDLERS = new HashMap<>();
        register(Byte.class, new ByteTypeHandler());
        register(byte.class, new ByteTypeHandler());
        register(Short.class, new ShortTypeHandler());
        register(short.class, new ShortTypeHandler());
        register(Integer.class, new IntegerTypeHandler());
        register(int.class, new IntegerTypeHandler());
        register(Long.class, new LongTypeHandler());
        register(long.class, new LongTypeHandler());
        register(Double.class, new DoubleTypeHandler());
        register(double.class, new DoubleTypeHandler());
        register(Float.class, new FloatTypeHandler());
        register(float.class, new FloatTypeHandler());
        register(Boolean.class, new BooleanTypeHandler());
        register(boolean.class, new BooleanTypeHandler());
        register(Character.class, new CharTypeHandler());
        register(char.class, new CharTypeHandler());
        register(String.class, new StringTypeHandler());
        register(Date.class, new DateTypeHandler());
    }

    public static <T> void register(Class<T> type, TypeHandler<T> typeHandler) {
        ALL_TYPE_HANDLERS.put(type, typeHandler);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getObject(String value, Type type) {
        if (value == null || "".equals(value)) {
            return null;
        }
        TypeHandler typeHandler = ALL_TYPE_HANDLERS.get(type);
        if (typeHandler != null) {
            return (T) typeHandler.get(value);
        }
        // 其他类型，统一使用FastJson解析
        return JSONObject.parseObject(value, type);
    }

    @SuppressWarnings("unchecked")
    public static <T> String getString(Class<T> objType, T obj) {
        if (obj == null) {
            return null;
        }
        TypeHandler typeHandler = ALL_TYPE_HANDLERS.get(objType);
        if (typeHandler != null) {
            return typeHandler.getString(obj);
        }
        return JSONObject.toJSONString(obj);

    }

}
