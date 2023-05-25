package com.uniubi.cloud.athena.sdk.common.exception;

/**
 * com.uniubi.cloud.aiot.sdk.common.exceptioins.UniUbiAthenaSDKException
 * @author jingmu
 * @since 2020/3/26
 */
public class UniUbiAthenaSDKException extends RuntimeException {

    public UniUbiAthenaSDKException() {
    }

    public UniUbiAthenaSDKException(String message) {
        super(message);
    }

    public UniUbiAthenaSDKException(String message, Throwable cause) {
        super(message, cause);
    }

    public UniUbiAthenaSDKException(Throwable cause) {
        super(cause);
    }

    public UniUbiAthenaSDKException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
