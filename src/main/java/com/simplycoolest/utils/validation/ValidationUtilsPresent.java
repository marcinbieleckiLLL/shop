package com.simplycoolest.utils.validation;

import com.simplycoolest.utils.annotations.logging.LogMethodName;

/**
 * Created by Marcin on 01.05.2018.
 */
public interface ValidationUtilsPresent {
    <T extends Object> ValidationErrors validateAlreadyPresent(T t);
}
