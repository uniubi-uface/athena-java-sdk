package com.uniubi.athena;

import com.uniubi.cloud.athena.sdk.common.utils.AthenaSdkEncrypt;
import org.junit.Test;

/**
 * @author 井木
 * @since 2022/09/14
 */
public class AthenaSdkEncryptTest {

    @Test
    public void testDecryptRSA() throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCRvY6qyZmXZEtSfXxUoJO0oDdX5K4Ai0fxJfIHhfyLMP+iLurWpZNM6xz3ZLk+H/yTmT/RJSQytNaX+I75CYIO2T/gix97vKTwLvQ0N3IPluyAz/yCRrd4fSzXlYn8kpEQZZqXCqc3uKx/deZV2qVz2lhm7T9L0KLXCKqaJF7RLQIDAQAB";
        String secret = "Rbdy6eEus30IojrRlOzOpjPdpWWO1hU9S4KkNz9il6aNHRKUhIhXM7uTzKL9+ZSL+fzEjZF5wedifzv9VYnv6x4sbpy8CzINKH3VGlLOSx/TXE0ec+k1N1XVyD6ukLx5NSinAN7g4ksnTusOJJYAEt8srsk/amxur3aWCFObRrY=";
        String decryptByPublicKey = AthenaSdkEncrypt.decryptByPublicKey(secret, publicKey);
        System.out.println(decryptByPublicKey);
    }


    @Test
    public void testDecryptAes() throws Exception {
        String iv = "3f2b171a62400534";
        String aesKey = "d8d3ecb852ea69fb43500426a171b2f3";
        String secretData = "wUgQj881vkn2BBAWujffTZNABhTDZMc//CLzmbcbrvm9ah8kweq0Q78I9ZhplYUA";
        String decryptByPublicKey = AthenaSdkEncrypt.decryptByAes(aesKey, secretData);
        System.out.println(decryptByPublicKey);
    }

    @Test
    public void testGenerateAesKey() {
        String aesKey = AthenaSdkEncrypt.generateAesKey();
        System.out.println(aesKey);
    }

    @Test
    public void testAesEncrypt() {
        String key = "298eae75121219e5c05e34d365f7d20b";
        String content = " {\n" +
                "      \"requestData\": {\n" +
                "      \"pageSize\": 10,\n" +
                "      \"pageNum\": 1\n" +
                "      }\n" +
                "   }";
        String encryptByAes = AthenaSdkEncrypt.encryptByAes(key, content);
        System.out.println(encryptByAes);
    }
}
