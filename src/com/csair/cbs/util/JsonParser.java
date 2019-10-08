package com.csair.cbs.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * tangqm
 * 2019年9月24日
 */
public class JsonParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonParser.class);

    //正常的序列化     FAIL_ON_EMPTY_BEANS
    private static ObjectMapper objectMapper;
    //触屏使用此Mapper
    private static ObjectMapper objectMapperTouch;
    static{
        JaxbAnnotationModule jaxbMod = new JaxbAnnotationModule();
        jaxbMod.setPriority(JaxbAnnotationModule.Priority.SECONDARY);

        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(jaxbMod);

        //触屏object转json不忽略null字段
        objectMapperTouch = new ObjectMapper();
        objectMapperTouch.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapperTouch.registerModule(jaxbMod);

    }


    /**
     * 将对象转化为普通的JSON
     * @throws JsonProcessingException
     */
    public static String toJson(Object o) throws IOException {
        return objectMapper.writeValueAsString(o);
    }
    /**
     * 将对象转化为普通的JSON--touch
     * @throws JsonProcessingException
     */
    public static String toJsonForTouch(Object o) throws  IOException {
        return objectMapperTouch.writeValueAsString(o);
    }
    /**
     * 将对象List转化为普通的JSON
     */
    public static String toJson(List<Object> list) {
        String rtv ;
        StringBuilder sb = new StringBuilder();
        try {
            for (Object bean : list) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(objectMapper.writeValueAsString(bean));
            }
            rtv = "[" + sb.toString() + "]";
        } catch (Exception e) {
            LOGGER.error(sb.toString(),e);
            throw new IllegalArgumentException(e);
        }
        return rtv;
    }
    /**
     * 反序列化為普通對象
     * @throws IOException
     */
    public static <T> T fromJson(String jsonStr, Class<T> clazz) throws  IOException {
        return objectMapper.readValue(jsonStr, clazz);
    }


    @SuppressWarnings("rawtypes")
    public static <T> T fromJson(String jsonStr, TypeReference typeReference) throws  IOException {
        return objectMapper.readValue(jsonStr,typeReference);
    }

    @SuppressWarnings("rawtypes")
    public static String toJson(Map map) throws JsonProcessingException {
        return objectMapper.writeValueAsString(map);
    }




    /**
     * 转换成Json, 转换出错不抛出异常
     * @param obj
     * @return
     */
    public static  String toJsonQuietly(Object obj) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("toJsonQuietly异常", e);
        }
        return json;
    }
}
