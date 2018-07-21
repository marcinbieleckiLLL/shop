package com.simplycoolest.utils.validation;

import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by Marcin on 25.02.2018.
 */
public interface ValidationUtils {
    <T extends Object> List<ValidationErrors> validate(T t);
}
