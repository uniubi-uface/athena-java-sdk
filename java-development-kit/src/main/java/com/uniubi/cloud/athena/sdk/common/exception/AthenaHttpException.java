package com.uniubi.cloud.athena.sdk.common.exception;

/**
 * com.uniubi.medusa.ares.develop.common.http.AthenaHttpException
 *
 * @author jingmu
 * @date 2020/6/17
 */
public class AthenaHttpException extends RuntimeException {

    private static final long serialVersionUID = 8310550678065443873L;

    public AthenaHttpException(String message) {
        super(message);
    }

}
