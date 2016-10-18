package com.hloong.base.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map 转 Json
 * 
 * @author XiongHeng create at 2015-12-12 下午2:51:00
 * */
public class MapToJson {

    /**
     * Map<String, Object> 转 Json
     * 
     * @param Map
     *            <String, Object> 此处为Map 对象
     * @return json.toString
     * */
    public static String ObjectToJson(Map<String, Object> map) {
        Set<String> keys = map.keySet();
        String key = "";
        Object value;
        StringBuffer jsonBuffer = new StringBuffer();
        jsonBuffer.append("{");
        for (Iterator<String> it = keys.iterator(); it.hasNext();) {
            key = (String) it.next();
            value = map.get(key);
            if (value instanceof String) {
                value = '"' + value.toString() + '"';
            }
            jsonBuffer.append('"' + key + '"' + ":" + value);
            if (it.hasNext()) {
                jsonBuffer.append(",");
            }
        }

        jsonBuffer.append("}");
        return jsonBuffer.toString();
    }

    /**
     * Map<String, String> 转 Json
     * 
     * @param Map
     *            <String, String> 此处为Map 对象
     * @return json.toString
     * */
    public static String StringToJson(Map<String, String> map) {
        Set<Map.Entry<String, String>> entrys = map.entrySet();
        Map.Entry<String, String> entry = null;
        String key = "";
        String value = "";
        StringBuffer jsonBuffer = new StringBuffer();
        jsonBuffer.append("{");
        for (Iterator<Map.Entry<String, String>> it = entrys.iterator(); it
                .hasNext();) {
            entry = (Map.Entry<String, String>) it.next();
            key = entry.getKey();
            value = entry.getValue();
            if (value instanceof String) {
                value = '"' + value.toString() + '"';
            }
            jsonBuffer.append('"' + key + '"' + ":" + value);
            if (it.hasNext()) {
                jsonBuffer.append(",");
            }
        }
        jsonBuffer.append("}");
        return jsonBuffer.toString();
    }

}
