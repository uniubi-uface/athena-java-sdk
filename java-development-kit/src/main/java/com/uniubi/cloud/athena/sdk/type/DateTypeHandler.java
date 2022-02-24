package com.uniubi.cloud.athena.sdk.type;

import java.util.Date;

/**
 * com.uniubi.cloud.funx.type.DateTypeHandler
 *
 * @author jingmu
 * @date 2020/3/20
 */
public class DateTypeHandler implements TypeHandler<Date> {

    @Override
    public Date get(String str) {
        long timeMillis = Long.parseLong(str);
        return new Date(timeMillis);
    }

    @Override
    public String getString(Date date) {

        return String.valueOf(date.getTime());
    }

}
