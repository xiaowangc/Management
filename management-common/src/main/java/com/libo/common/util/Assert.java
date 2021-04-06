package com.libo.common.util;

import com.libo.common.exception.ResponseException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class Assert {

    public static void isBlank(String str, String msg) {
        if (StringUtils.isBlank(str)) {
            throw new ResponseException(msg);
        }
    }
    public static void isNull(Object obj, String msg) {
        if (obj == null) {
            throw new ResponseException(msg);
        }
    }

    public static void isCollectionNull(Collection<?> collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new ResponseException(msg);
        }
    }
}
