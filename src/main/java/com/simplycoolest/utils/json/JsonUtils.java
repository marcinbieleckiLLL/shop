package com.simplycoolest.utils.json;

import com.simplycoolest.error.ShouldBeAjaxSendObjectQueryException;
import com.simplycoolest.utils.annotations.logging.LogMethodName;

import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 25.02.2018.
 */
public interface JsonUtils {
    String listToJson(List<?> listToConvert);
    Map<String, String> getParamsFromAjax(String json) throws ShouldBeAjaxSendObjectQueryException;
}
