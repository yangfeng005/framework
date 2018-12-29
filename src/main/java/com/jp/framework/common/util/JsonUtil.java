package com.jp.framework.common.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

public class JsonUtil {
    private static ObjectMapper JSON = new ObjectMapper();

    static {
        JSON.setSerializationInclusion(Include.NON_NULL);
        JSON.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }

    public JsonUtil() {
    }

    public static String getJsonFromObject(Object obj) {
        if(obj == null) {
            return null;
        } else {
            try {
                return JSON.writeValueAsString(obj);
            } catch (Exception var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static <T> T getObjectFromJson(String json, Class<T> valueType) {
        if(StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                return JSON.readValue(json, valueType);
            } catch (Exception var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    public static <T> T getObjectFromJson(String json, TypeReference<T> valueTupeRef) {
        if(StringUtils.isEmpty(json)) {
            return null;
        } else {
            try {
                return JSON.readValue(json, valueTupeRef);
            } catch (Exception var3) {
                throw new RuntimeException(var3);
            }
        }
    }
}
