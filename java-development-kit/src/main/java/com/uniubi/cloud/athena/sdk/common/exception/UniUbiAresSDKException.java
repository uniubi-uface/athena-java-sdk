package com.uniubi.cloud.athena.sdk.common.exception;

/**
 * com.uniubi.cloud.aiot.sdk.common.exceptioins.UniUbiAresSDKException
 *
 * @author jingmu
 * @date 2020/3/26
 */
public class UniUbiAresSDKException extends RuntimeException {

    public UniUbiAresSDKException() {
    }

    public UniUbiAresSDKException(String message) {
        super(message);
    }

    public UniUbiAresSDKException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniUbiAresSDKException(Throwable cause) {
        super(cause);
    }

    public UniUbiAresSDKException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
