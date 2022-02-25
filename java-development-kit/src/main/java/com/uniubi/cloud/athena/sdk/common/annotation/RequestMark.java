package com.uniubi.cloud.athena.sdk.common.annotation;

import com.uniubi.cloud.athena.sdk.common.UniUbiSdkClientProxyFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求标注注解 name属性表示请求唯一标识，该属性会被 UniUbiSdkClientProxyFactory 中的代理方法中被扫描获取到
 * 并用来作为请求服务端的requestKey放入请求头部中 desc只是用来作为方法的描述性信息 UniUbiSdkClientProxyFactory.ClientProxy
 * 客户端代理对象
 *
 * @author jingmu
 * @see UniUbiSdkClientProxyFactory 客户端代理工厂
 * @since 2020/3/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMark {

    String name();

    String desc();

    String version();

}
