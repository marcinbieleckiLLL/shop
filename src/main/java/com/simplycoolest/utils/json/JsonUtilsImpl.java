package com.simplycoolest.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.simplycoolest.error.ShouldBeAjaxSendObjectQueryException;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Marcin on 25.02.2018.
 */
@Service
public class JsonUtilsImpl implements JsonUtils {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private ObjectMapper objectMapper;

    @LogMethodName(value = JsonUtils.class)
    @Override
    public String listToJson(List<?> listToConvert) {
        createObjectMapper();
        try {
            return objectMapper.writeValueAsString(listToConvert);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new String();
        }
    }

    private void createObjectMapper(){
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public Map<String, String> getParamsFromAjax(String json) throws ShouldBeAjaxSendObjectQueryException {
        try{
            String[] params = json.split("&");
            return Arrays
                    .stream(params)
                    .map(paramAndValue -> paramAndValue.split("="))
                    .filter(e -> e.length == 2)
                    .collect(Collectors.toMap(e -> e[0], e -> e[1]));
        }catch(Exception e){
            logger.error(e.getMessage());
            throw new ShouldBeAjaxSendObjectQueryException();
        }
    }
}
