package com.uniubi.cloud.athena.sdk.decrypt;

import com.alibaba.fastjson.JSONObject;
import com.uniubi.cloud.athena.sdk.common.exception.UniUbiAresSDKException;
import com.uniubi.cloud.athena.sdk.common.http.defaults.DefaultResponseConverter;
import com.uniubi.cloud.athena.sdk.common.models.SdkResult;
import com.uniubi.cloud.athena.sdk.common.utils.AthenaSdkEncrypt;
import com.uniubi.cloud.athena.sdk.type.TypeHandlerRegistry;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 公钥解密响应处理器
 *
 * @author jingmu
 * @since 2020/6/9
 */
public class DecryptResponseConverter extends DefaultResponseConverter {

    private final String publicKey;

    public DecryptResponseConverter(String publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T converter(String responseContent, Type classType) {
        ContentResult contentResult = JSONObject.parseObject(responseContent, ContentResult.class);
        String encryptData = (String) contentResult.getData();
        if (StringUtils.isEmpty(encryptData) || StringUtils.isEmpty(contentResult.secret)) {
            return super.converter(responseContent, classType);
        }
        try {
            Type[] typeArguments = ((ParameterizedType) classType).getActualTypeArguments();
            if (typeArguments == null || typeArguments.length == 0) {
                contentResult.setSecret(null);
                return (T) contentResult;
            }
            // 第一步使用公钥给口令解密
            String aesKey = AthenaSdkEncrypt.decryptByPublicKey(contentResult.secret, publicKey);
            // 第二步使用口令解密数据内容
            responseContent = AthenaSdkEncrypt.decryptByAes(aesKey, encryptData);
            Object result = TypeHandlerRegistry.getObject(responseContent, typeArguments[0]);
            contentResult.setData(result);
            contentResult.setSecret(null);
            return (T) contentResult;
        }
        catch (Exception e) {
            throw new UniUbiAresSDKException(e);
        }
    }

    /**
     * @author admin
     */
    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
    public static class ContentResult extends SdkResult {

        private String secret;

    }

}
