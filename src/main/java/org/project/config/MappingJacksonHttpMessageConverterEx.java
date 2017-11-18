package org.project.config;

/**
 * Created by gao on 16-11-5.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class MappingJacksonHttpMessageConverterEx extends MappingJackson2HttpMessageConverter {
    private ObjectMapper objectMapper = new ObjectMapper();

    public MappingJacksonHttpMessageConverterEx() {
        super();
        DeserializationConfig deserializationConfig = objectMapper.getDeserializationConfig().without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setConfig(deserializationConfig);
        SerializationConfig serializationConfig = objectMapper.getSerializationConfig().without(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setConfig(serializationConfig);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        setObjectMapper(objectMapper);
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        JavaType javaType = getJavaType(null, clazz);
        return this.objectMapper.readValue(inputMessage.getBody(), javaType);
    }
}
